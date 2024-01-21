import com.seiko.imageloader.ImageLoaderConfigBuilder
import com.seiko.imageloader.util.LogPriority
import com.seiko.imageloader.util.Logger

fun ImageLoaderConfigBuilder.commonConfig() {
    logger = object : Logger {
        override fun isLoggable(priority: LogPriority): Boolean = true

        override fun log(
            priority: LogPriority,
            tag: String,
            data: Any?,
            throwable: Throwable?,
            message: String
        ) {
            val text = buildString {
                if (data != null) {
                    append("[image data] ")
                    append(data.toString().take(100))
                    append('\n')
                }
                append("[message] ")
                append(message)
            }
            println("$priority $tag $text")
        }

    }
}

val imageUrl =
    "https://fastly.picsum.photos/id/1/5000/3333.jpg?hmac=Asv2DU3rA_5D1xSe22xZK47WEAN0wjWeFOhzd13ujW4"