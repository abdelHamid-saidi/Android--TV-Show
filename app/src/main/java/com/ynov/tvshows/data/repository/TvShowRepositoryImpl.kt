package data.repository

import data.dto.toDomain
import data.service.TvShowApiService
import domain.model.ShowDetails
import domain.model.TvShow
import domain.repository.TvShowRepository
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val api: TvShowApiService
) : TvShowRepository {

    override suspend fun getPopularShows(page: Int): List<TvShow> {
        return api.getPopularShows(page).tv_shows.map { it.toDomain() }
    }

    override suspend fun getShowDetails(showName: String): ShowDetails {
        val dto = api.getShowDetails(showName).tvShow
        return ShowDetails(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            imageUrl = dto.image_path
        )
    }
}
