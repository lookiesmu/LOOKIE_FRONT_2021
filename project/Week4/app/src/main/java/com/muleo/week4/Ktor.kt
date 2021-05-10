package com.muleo.week4

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*


object Ktor {
    //Expires: Mon, May 10th, 2021 @ 9:28am (PT) in 23 hours and 59 minutes
    const val API_KEY = "RGAPI-b9b60e37-0374-4184-8b87-31b3a52cd020"
    const val KR_URL = "https://kr.api.riotgames.com"
    const val ASIA_URL = "https://asia.api.riotgames.com"

    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    private const val SUMMONER_V4 = "/lol/summoner/v4/summoners"
    private const val BY_NAME = "/by-name/"
    suspend fun summonerByName(name: String): Summoner {
        val summonerName = name.trim().replace(" ", "%20")
        val requestURL = "$KR_URL$SUMMONER_V4$BY_NAME$summonerName"
        return client.get<Summoner>(requestURL) {
            header("X-Riot-Token", API_KEY)
        }
    }

    suspend fun matchList(puuid: String, start: Int = 0 ,count: Int = 20): List<String> {
        val match_v5_puuid = "/lol/match/v5/matches/by-puuid/$puuid/ids"
        val requestURL = "$ASIA_URL$match_v5_puuid"
        return client.get(requestURL) {
            header("X-Riot-Token", API_KEY)
            parameter("start", start)
            parameter("count", count)
        }
    }
    const val MATCH_V5 = "/lol/match/v5/matches/"
    suspend fun match(matchId: String): Match {
        val requestURL = "$ASIA_URL$MATCH_V5${matchId}"
        return client.get(requestURL) {
            header("X-Riot-Token", API_KEY)
        }
    }

}