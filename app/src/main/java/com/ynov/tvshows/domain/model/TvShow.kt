package domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val permalink: String,
    val start_date: String?,
    val end_date: String?,
    val country: String?,
    val network: String?,
    val status: String?,
    val imageUrl: String
)