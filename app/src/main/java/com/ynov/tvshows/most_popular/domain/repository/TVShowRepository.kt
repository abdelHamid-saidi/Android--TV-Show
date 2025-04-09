package com.ynov.tvshows.most_popular.domain.repository

import com.ynov.tvshows.most_popular.domain.model.TvShow

interface TVShowRepository {
    suspend fun getPopularShows(): List<TvShow>
}