package domain.usecase

import domain.model.TvShow
import domain.repository.TvShowRepository

class GetPopularShowsUseCase(private val repository: TvShowRepository) {
    suspend operator fun invoke(page: Int): List<TvShow> = repository.getPopularShows(page)
}
