package com.muleo.week4

data class Summoner(
    val id: String = "",
    val accountId: String = "",
    val puuid: String = "",
    val name: String = "",
    val profileIconId: Int = -1,
    val revisionDate: Long = -1,
    val summonerLevel: Int = -1
) {
    var isLoaded: Boolean = true
    var error: String = ""
}