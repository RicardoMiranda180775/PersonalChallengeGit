package com.ricardomiranda.personalchallenge.models

data class RecyclerList(val items: ArrayList<RecyclerData>)
data class RecyclerData(
    val name: String,
    val description: String,
    val owner: Owner,
    val stargazers_count: String,
    val forks_count: String,
    val full_name: String
)

data class Owner(val avatar_url: String)
