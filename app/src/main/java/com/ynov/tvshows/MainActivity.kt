package com.ynov.tvshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import dagger.hilt.android.AndroidEntryPoint
import presentation.ui.screens.TvShowListScreen
import com.ynov.tvshows.ui.theme.TvShowTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TvShowListScreen()
                }
            }
        }
    }
}
