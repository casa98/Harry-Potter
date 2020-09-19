package com.cagudeloa.harrypotter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.cagudeloa.harrypotter.domain.Repository
import com.cagudeloa.harrypotter.vo.Resource
import kotlinx.coroutines.Dispatchers

// As this ViewModel receives a param, I'll have to implement ViewModelFactory class
class ChosenCategoryViewModel(private val repository: Repository): ViewModel() {

    /**
     * From here I'll get my info that's on Repository (delivered to Repository via DataSource)
     */

    // This data will be listened from the UI
    val fetchStudentsList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repository.getStudents())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    val fetchStaffList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repository.getStaff())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    val fetchHouseList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repository.getHouse())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

}