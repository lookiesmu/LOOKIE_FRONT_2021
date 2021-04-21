package com.muleo.wek2.network

import com.muleo.wek2.giphy.Giphy
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

object Ktor {
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun ktor_url(query: String = "manga"): Giphy {
        val url =
            "https://api.giphy.com/v1/gifs/search?api_key=nxUAbMNh0RrkuCanBY1zUmYDLfi6lyXH&q=${query}"
        return client.get(url)
    }
}

