package com.coldweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.coldweather.android.logic.Repository
import com.coldweather.android.logic.model.Place

class PlaceViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Repository.searchPlces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value = query
    }
}