package com.example.rabbit_ktor_example.data

import retrofit2.http.GET


interface RabbitsApi {

    @GET("/randomrabbit")
    suspend fun getRandomRabbit(): Rabbit

    @GET("/firstrabbit")
    suspend fun getFirstRabbit(): Rabbit

    @GET("/secondrabbit")
    suspend fun getSecondRabbit(): Rabbit

    @GET("/thirdrabbit")
    suspend fun getThirdRabbit(): Rabbit

    @GET("/fourthrabbit")
    suspend fun getFourthRabbit(): Rabbit

    @GET("/fifthrabbit")
    suspend fun getFifthRabbit(): Rabbit


    companion object {
        const val BASE_URL = "http://192.168.66.160:8080"
    }
}