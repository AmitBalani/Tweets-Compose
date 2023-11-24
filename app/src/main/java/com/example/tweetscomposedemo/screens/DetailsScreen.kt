package com.example.tweetscomposedemo.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetscomposedemo.viewmodels.DetailsViewModel


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val tweets = detailsViewModel.tweets.collectAsState()
    LazyColumn(

    ) {
        items(tweets.value) {
            TweetListItem(tweet = it.text)
        }
    }
}


@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        Text(
            text = tweet,
            modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium
        )
    }
}