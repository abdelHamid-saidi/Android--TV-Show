package com.ynov.tvshows.most_popular.domain.use_case

import com.ynov.tvshows.most_popular.domain.model.TvShow
import com.ynov.tvshows.most_popular.domain.repository.TVShowRepository


class GetPopularTVShowsUseCase(
    private val repository: TVShowRepository
) {
    suspend operator fun invoke(): List<TvShow> {
        return repository.getPopularShows()
    }
}
