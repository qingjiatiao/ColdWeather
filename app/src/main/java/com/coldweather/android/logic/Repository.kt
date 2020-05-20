package com.coldweather.android.logic

import androidx.lifecycle.liveData
import com.coldweather.android.logic.model.Place
import com.coldweather.android.logic.network.ColdWeatherNetwork
import com.coldweather.android.logic.network.PlaceService
import com.coldweather.android.logic.network.ServiceCreator
import kotlinx.coroutines.Dispatchers
import retrofit2.await
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchPlces(query:String) = liveData(Dispatchers.IO)  {
        val result : Result<List<Place>> = try {
            val placeService = ServiceCreator.create<PlaceService>()
            suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()
            val placeResponse = searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}