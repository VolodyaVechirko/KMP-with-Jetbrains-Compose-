package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

const val PHOTO_URL = "https://picsum.photos/v2/list?page=2&limit=100"
const val LIMIT = 40

class ApiService {
    private val httpClient = HttpClient {
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getPhotos(page: Int): List<PhotoModel> {
        delay(500) // emulate loading
        val url = "https://picsum.photos/v2/list?page=$page&limit=$LIMIT"
        return httpClient.get(url).body()
    }

    suspend fun getPhoto(id: String): PhotoModel {
        delay(200) // emulate loading
        val url = "https://picsum.photos/id/$id/info"
        return httpClient.get(url).body()
    }
}