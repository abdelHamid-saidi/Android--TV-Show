package com.ynov.tvshows.most_popular.presentation.viewModel


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynov.tvshows.most_popular.domain.model.TvShow
import com.ynov.tvshows.most_popular.domain.use_case.GetPopularTVShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVShowViewModel @Inject constructor(
    private val getPopularTVShowsUseCase: GetPopularTVShowsUseCase
) : ViewModel() {

    // État pour les émissions populaires
    var popularShows by mutableStateOf<List<TvShow>>(emptyList())
        private set

    // État pour le chargement
    var isLoading by mutableStateOf(false)
        private set

    // État pour les erreurs
    var errorMessage by mutableStateOf<String?>(null)
        private set

    // Fonction pour récupérer les émissions populaires
    fun getPopularTVShows() {
        isLoading = true
        viewModelScope.launch {
            try {
                val shows = getPopularTVShowsUseCase()
                popularShows = shows
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}
