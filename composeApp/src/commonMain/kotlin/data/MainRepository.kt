package data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class MainRepository(
    private val apiService: ApiService
) {
    suspend fun getPhotos(): Result<List<PhotoModel>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                apiService.getPhotos(page = 2)
            }
        }
    }

    suspend fun getPhoto(id: String): Result<PhotoModel> {
        return withContext(Dispatchers.IO) {
            runCatching {
                apiService.getPhoto(id = id)
            }
        }
    }
}