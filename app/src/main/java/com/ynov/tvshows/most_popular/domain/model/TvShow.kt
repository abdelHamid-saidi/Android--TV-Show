package com.ynov.tvshows.most_popular.domain.model

import com.ynov.tvshows.most_popular.data.dto.TvShowDto

data class TvShow(
    val id: Int,
    val name: String,
    val imageThumbnailPath: String
)

