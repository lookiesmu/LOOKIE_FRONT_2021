package com.muleo.wek2.giphy

data class Giphy(
    val `data`: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)