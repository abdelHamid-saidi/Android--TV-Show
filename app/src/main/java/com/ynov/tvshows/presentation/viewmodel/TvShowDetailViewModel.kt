package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.model.ShowDetails
import domain.usecase.GetShowDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(
    private val getShowDetailsUseCase: GetShowDetailsUseCase
) : ViewModel() {

    private val _details = MutableStateFlow<ShowDetails?>(null)
    val details: StateFlow<ShowDetails?> = _details

    fun loadDetails(permalink: String) {
        viewModelScope.launch {
            try {
                _details.value = getShowDetailsUseCase(permalink)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
