package domain.usecase

import domain.model.ShowDetails
import domain.repository.TvShowRepository

class GetShowDetailsUseCase(private val repository: TvShowRepository) {
    suspend operator fun invoke(showName: String): ShowDetails = repository.getShowDetails(showName)
}