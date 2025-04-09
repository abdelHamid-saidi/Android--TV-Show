package com.ynov.tvshows.most_popular.data.service

import com.ynov.tvshows.most_popular.data.dto.PopularShowsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TVShowApi {

    @GET("most-popular")
    suspend fun getMostPopularShows(
        @Query("page") page: Int = 1
    ): PopularShowsResponseDto
}
