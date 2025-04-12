package domain.usecase

import domain.model.ShowDetails
import domain.repository.TvShowRepository
import javax.inject.Inject

class GetShowDetailsUseCase @Inject constructor(
    private val repository: TvShowRepository
) {
    suspend operator fun invoke(showName: String): ShowDetails =
        repository.getShowDetails(showName)
}
