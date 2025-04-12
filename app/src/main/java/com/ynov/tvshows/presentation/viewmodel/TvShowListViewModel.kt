package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.TvShow
import domain.usecase.GetPopularShowsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TvShowListViewModel(private val getPopularShows: GetPopularShowsUseCase) : ViewModel() {
    private val _shows = MutableStateFlow<List<TvShow>>(emptyList())
    val shows: StateFlow<List<TvShow>> = _shows

    init {
        loadShows()
    }

    private fun loadShows() {
        viewModelScope.launch {
            _shows.value = getPopularShows(1)
        }
    }
}