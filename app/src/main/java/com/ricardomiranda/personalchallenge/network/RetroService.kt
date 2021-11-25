package com.ricardomiranda.personalchallenge.network

import com.ricardomiranda.personalchallenge.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(
        @Query("q") query : String,
        @Query("sort") sort: String,
        @Query("page") page: String,
    ): RecyclerList
}

//q=language:kotlin&sort=stars&page=1