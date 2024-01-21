import com.seiko.imageloader.ImageLoaderConfigBuilder
import com.seiko.imageloader.util.LogPriority
import com.seiko.imageloader.util.Logger

/**
 * Basic config for ImageLoader (logger config)
 */
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