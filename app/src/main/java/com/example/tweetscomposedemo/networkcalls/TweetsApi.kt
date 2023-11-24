package com.example.tweetscomposedemo.networkcalls

import com.example.tweetscomposedemo.models.TweetListModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    @GET("v3/b/655c4b610574da7622c99874?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListModelItem>>

    @GET("v3/b/655c4b610574da7622c99874?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory() : Response<List<String>>
}