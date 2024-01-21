import android.content.Context
import okio.Path
import okio.Path.Companion.toOkioPath

/**
 * Android cache dir access sample
 */
fun getCachePath(context: Context): Path {
    return context.cacheDir.resolve("image_cache")
        .toOkioPath()
}