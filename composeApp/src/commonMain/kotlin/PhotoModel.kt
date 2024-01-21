import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * {
 *         "id": "0",
 *         "author": "Alejandro Escamilla",
 *         "width": 5616,
 *         "height": 3744,
 *         "url": "https://unsplash.com/...",
 *         "download_url": "https://picsum.photos/..."
 * }
 */
@Serializable
class PhotoModel(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    @SerialName("download_url")
    val url: String,
    @SerialName("url")
    val webUrl: String,
) {
    val ratio: Float
        get() = width.toFloat() / height
}