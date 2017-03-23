package com.tgirard12.kotlintalk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.chibatching.kotpref.Kotpref
import com.google.gson.Gson
import com.tinsuke.icekick.extension.freezeInstanceState
import com.tinsuke.icekick.extension.serialState
import com.tinsuke.icekick.extension.unfreezeInstanceState
import kotlinx.android.synthetic.main.search_activity.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchActivity : AppCompatActivity() {

    val gson = Gson()
    val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    val githubService: GithubService = retrofit.create(GithubService::class.java)

    val toolbar: Toolbar by bindView(R.id.toolbar)

    var nbSearch: Int by serialState(0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Kotpref.init(this.applicationContext)
        unfreezeInstanceState(savedInstanceState)

        setContentView(R.layout.search_activity)
        setSupportActionBar(toolbar)

        val updateHint = { searchText.hint = "$nbSearch search, last = ${Prefs.search}" }
        updateHint()

        searchButton.setOnClickListener {
            Log.i("SEARCH", "text: ${searchText.text}")

            nbSearch++
            Prefs.search = searchText.text.toString()
            searchText textIs ""
            updateHint()

            githubService.githubSearch(Prefs.search).enqueue {
                onResponse { _, response ->

                    val search = response.body().items?.getOrNull(0)
                    search.let {
                        name textIs (it?.name ?: "not Found")
                        fullName textIs it?.full_name
                        htmlUrl textIs it?.html_url
                        description textIs it?.description

                        owner textIs it?.owner?.login
                        owerAvatar loadUrl it?.owner?.avatar_url

                        fab.apply {
                            visibility = if (it?.html_url == null) View.INVISIBLE else View.VISIBLE
                            setOnClickListener { _ ->
                                it?.html_url?.let { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it))) }
                            }
                        }
                    }
                }
                onFailure { _, t ->
                    Log.i("ERROR", "${t.message}")
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        freezeInstanceState(outState)
    }
}
