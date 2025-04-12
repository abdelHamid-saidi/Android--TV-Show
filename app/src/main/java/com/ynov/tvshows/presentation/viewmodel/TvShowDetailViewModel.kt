package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.ShowDetails
import domain.usecase.GetShowDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TvShowDetailViewModel(private val getShowDetails: GetShowDetailsUseCase) : ViewModel() {
    private val _details = MutableStateFlow<ShowDetails?>(null)
    val details: StateFlow<ShowDetails?> = _details

    fun loadShowDetails(showName: String) {
        viewModelScope.launch {
            _details.value = getShowDetails(showName)
        }
    }
}