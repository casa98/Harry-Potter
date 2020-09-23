package com.cagudeloa.harrypotter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.cagudeloa.harrypotter.domain.Repository
import com.cagudeloa.harrypotter.vo.Resource
import kotlinx.coroutines.Dispatchers

class DetailHouseViewModel(private val repository: Repository): ViewModel() {

    val fetchHouseList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repository.getHouse())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

}