package com.app.edgeapi

import com.app.edgeapi.model.NewsResponse
import com.app.edgeapi.model.Source
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface ServiceApi {

    @GET("everything?q=tesla&from=2024-08-03&sortBy=publishedAt&apiKey=f3325619ee5a45c586ee134102d2df0f")
    fun getNewsArticle(): Call<NewsResponse>



}