package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.model.TvShow
import domain.usecase.GetPopularShowsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowListViewModel @Inject constructor(
    private val getPopularShows: GetPopularShowsUseCase
) : ViewModel() {

    private val _shows = MutableStateFlow<List<TvShow>>(emptyList())
    val shows: StateFlow<List<TvShow>> = _shows

    init {
        loadShows()
    }

    private fun loadShows() {
        viewModelScope.launch {
            viewModelScope.launch {
                try {
                    val result = getPopularShows(1)
                    println("🎬 SHOWS = $result") // 👈 Affiche les données dans Logcat
                    _shows.value = result
                } catch (e: Exception) {
                    e.printStackTrace() // Tu peux aussi exposer un Flow d’erreurs
                }
            }
        }
    }
}
