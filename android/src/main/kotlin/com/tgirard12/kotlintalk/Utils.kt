package com.tgirard12.kotlintalk

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.graphics.drawable.VectorDrawableCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified V : View> Activity.bindView(resId: Int): ReadOnlyProperty<Activity, V> = Delegate { this.findViewById(resId) as V }

class Delegate<in A, out V>(val funFindView: (A) -> V) : ReadOnlyProperty<A, V> {

    override fun getValue(thisRef: A, property: KProperty<*>): V {
        return funFindView(thisRef)
    }
}

fun Activity.snackbar(idRes: Int) = Snackbar.make(
        this.findViewById(android.R.id.content), this.getText(idRes), Snackbar.LENGTH_LONG).show()

fun Activity.createVector(idRes: Int) = VectorDrawableCompat.create(this.resources, idRes, this.theme)

infix fun TextView.textIs(value: String?) {
    this.text = value
}

infix fun ImageView.loadUrl(url: String?) {
    url?.let {
        Picasso.with(this.context.applicationContext)
                .load(it)
                .into(this)
    } ?: this.setImageDrawable(null)
}

/**
 *
 */
inline fun <reified T> Call<T>.enqueue(init: RetrofitTipsCallback<T>.() -> Unit) {
    enqueue(RetrofitTipsCallback<T>().apply(init))
}

class RetrofitTipsCallback<T> : Callback<T> {

    // Backing fields
    private lateinit var onResponse: (call: Call<T>?, response: Response<T>) -> Unit
    private lateinit var onFailure: (call: Call<T>, t: Throwable) -> Unit

    // DSL function
    fun onResponse(block: (call: Call<T>?, response: Response<T>) -> Unit) {
        onResponse = block
    }

    fun onFailure(block: (call: Call<T>, t: Throwable) -> Unit) {
        onFailure = block
    }

    // Retrofit method
    override fun onResponse(call: Call<T>?, response: Response<T>) {
        onResponse.invoke(call, response)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure.invoke(call, t)
    }
}

/**
 *
 */
annotation class GsonClass