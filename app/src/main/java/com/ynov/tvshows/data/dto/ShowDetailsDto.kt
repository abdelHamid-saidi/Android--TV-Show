package data.dto

data class ShowDetailsResponseDto(
    val tvShow: ShowDetailsDto
)

data class ShowDetailsDto(
    val id: Int,
    val name: String,
    val permalink: String,
    val url: String,
    val description: String,
    val description_source: String?,
    val start_date: String?,
    val end_date: String?,
    val country: String?,
    val status: String?,
    val runtime: Int?,
    val network: String?,
    val youtube_link: String?,
    val image_path: String,
    val image_thumbnail_path: String?,
    val rating: String?,
    val rating_count: Int?,
    val countdown: Any?,
    val genres: List<String>?,
    val pictures: List<String>?,
    val episodes: List<EpisodeDto>?
)