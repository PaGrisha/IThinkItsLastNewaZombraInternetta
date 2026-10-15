package com.example.ithinkitslastnewazombrainternetta.data.model.remote

import com.example.ithinkitslastnewazombrainternetta.data.model.PlantFromInternet
import com.example.ithinkitslastnewazombrainternetta.data.model.ZombrFromInternet
import retrofit2.http.GET
import retrofit2.http.Path

interface PvzApiService {

    @GET("plants")
    suspend fun getPlants(): List<String>

    @GET("zombies")
    suspend fun getZombies(): List<String>

    @GET("plants/{plantName}")
    suspend fun getPlantDetails(@Path("plantName") plantName: String): PlantFromInternet

    @GET("zombies/{zombieName}")
    suspend fun getZombieDetails(
        @Path("zombieName")
        zombieName: String
    ): ZombrFromInternet

}