package domain.repository

import domain.model.TvShow
import domain.model.ShowDetails

interface TvShowRepository {
    suspend fun getPopularShows(page: Int): List<TvShow>
    suspend fun getShowDetails(showName: String): ShowDetails
}