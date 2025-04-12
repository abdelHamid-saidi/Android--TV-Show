package data.dto

import domain.model.TvShow

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

data class PopularShowsResponseDto(
    val total: Int,
    val page: Int,
    val pages: Int,
    val tv_shows: List<TvShowDto>
)

fun TvShowDto.toDomain(): TvShow {
    return TvShow(
        id = id,
        name = name,
        permalink = permalink,
        start_date = start_date,
        end_date = end_date,
        country = country,
        network = network,
        status = status,
        imageUrl = image_thumbnail_path
    )
}
