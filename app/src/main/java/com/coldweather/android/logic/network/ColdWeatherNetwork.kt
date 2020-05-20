package com.coldweather.android.logic.network

import retrofit2.await

object ColdWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()
}