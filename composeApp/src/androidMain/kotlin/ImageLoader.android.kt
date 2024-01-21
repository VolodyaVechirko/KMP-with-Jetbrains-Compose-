import android.content.Context
import okio.Path
import okio.Path.Companion.toOkioPath

fun getCachePath(context: Context): Path {
    return context.cacheDir.resolve("image_cache")
        .toOkioPath()
}