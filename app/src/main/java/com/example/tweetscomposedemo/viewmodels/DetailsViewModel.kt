package com.example.tweetscomposedemo.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetscomposedemo.models.TweetListModelItem
import com.example.tweetscomposedemo.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: TweetsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweets: StateFlow<List<TweetListModelItem>>
        get() = repository.tweets


    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "sports"
            repository.getTweets(category)
        }
    }

}