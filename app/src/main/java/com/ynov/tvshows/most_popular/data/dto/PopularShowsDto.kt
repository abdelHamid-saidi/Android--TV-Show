package com.ynov.tvshows.most_popular.data.dto

data class PopularShowsResponseDto(
    val page: Int,
    val pages: Int,
    val tv_shows: List<TvShowDto>
)

data class TvShowDto(
    val id: Int,
    val name: String,
    val permalink: String,
    val start_date: String?,
    val end_date: String?,
    val country: String?,
    val network: String?,
    val status: String?,
    val image_thumbnail_path: String
)
