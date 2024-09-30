package platform.api

data class PostNewCodeDto(
    val code: String,
    val time: Int, // seconds till expiry 0 or less means no restriction
    val views: Int // uses before expiry
)