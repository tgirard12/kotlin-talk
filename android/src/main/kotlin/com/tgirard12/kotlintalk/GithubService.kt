package com.tgirard12.kotlintalk

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("/search/repositories")
    fun githubSearch(@Query("q") query: String): Call<Search>

}

data class Search(
        val total_count: Int,
        val isIncomplete_results: Boolean,
        val items: List<SearchItem>?
)

data class SearchItem(
        val id: Int,
        val name: String,
        val description: String?,
        val full_name: String?,
        val html_url: String,
        val owner: Owner
)

data class Owner(
        val login: String,
        val id: Long,
        val avatar_url: String?
)


