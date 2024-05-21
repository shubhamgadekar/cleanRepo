package com.alpha.cleanRepo.api

import retrofit2.Response
import retrofit2.http.GET

interface MyService {

    @GET("/endPoint")
    suspend fun getResponse(): Response<List<String>>

}