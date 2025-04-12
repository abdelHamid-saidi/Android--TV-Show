package data.repository

import data.service.TvShowApiService
import domain.model.ShowDetails
import domain.model.TvShow
import domain.repository.TvShowRepository

class TvShowRepositoryImpl(private val api: TvShowApiService) : TvShowRepository {
    override suspend fun getPopularShows(page: Int): List<TvShow> {
        return api.getPopularShows(page).tv_shows.map {
            TvShow(
                id = it.id,
                name = it.name,
                permalink = it.permalink,
                start_date = it.start_date,
                end_date = it.end_date,
                country = it.country,
                network = it.network,
                status = it.status,
                imageUrl = it.image_thumbnail_path
            )
        }
    }

    override suspend fun getShowDetails(showName: String): ShowDetails {
        val dto = api.getShowDetails(showName).tvShow
        return ShowDetails(id = dto.id, name = dto.name, description = dto.description, imageUrl = dto.image_path)
    }
}