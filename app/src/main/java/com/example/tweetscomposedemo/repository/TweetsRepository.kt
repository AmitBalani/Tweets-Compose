package com.example.tweetscomposedemo.repository

import com.example.tweetscomposedemo.models.TweetListModelItem
import com.example.tweetscomposedemo.networkcalls.TweetsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(val api: TweetsApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetListModelItem>>(emptyList())
    val tweets: StateFlow<List<TweetListModelItem>>
        get() = _tweets


    suspend fun getCategories() {
        val response = api.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String){
        val response = api.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }

}