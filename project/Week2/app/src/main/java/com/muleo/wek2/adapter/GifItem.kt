package com.muleo.wek2.adapter

const val url0 = "https://media.giphy.com/media/"
const val url1 = "/giphy.gif"

data class GifItem(
    val id: String,
    val title: String,
    val url: String = url0 +id+ url1
)
