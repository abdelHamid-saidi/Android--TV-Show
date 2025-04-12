package com.ynov.tvshows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import dagger.hilt.android.AndroidEntryPoint
import presentation.ui.screens.TvShowListScreen
import presentation.viewmodel.TvShowListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ynov.tvshows.ui.theme.TvShowsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val viewModel: TvShowListViewModel = viewModel()
                    TvShowListScreen(viewModel = viewModel) {
                        // TODO: Navigation vers l'écran de détails avec le showName
                    }
                }
            }
        }
    }
}
