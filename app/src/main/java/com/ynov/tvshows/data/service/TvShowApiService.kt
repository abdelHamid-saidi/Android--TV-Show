package data.service


import data.dto.PopularShowsResponseDto
import data.dto.ShowDetailsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApiService {
    @GET("most-popular")
    suspend fun getPopularShows(@Query("page") page: Int): PopularShowsResponseDto

    @GET("show-details")
    suspend fun getShowDetails(@Query("q") showName: String): ShowDetailsResponseDto
}