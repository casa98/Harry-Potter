package com.cagudeloa.harrypotter.ui.viewmodel

import androidx.lifecycle.*
import com.cagudeloa.harrypotter.domain.Repository
import com.cagudeloa.harrypotter.vo.Resource
import kotlinx.coroutines.Dispatchers

// As this ViewModel receives a param, I'll have to implement ViewModelFactory class
class ChosenCategoryViewModel(private val repository: Repository): ViewModel() {

    /**
     * From here I'll get my info that's on Repository (delivered to Repository via DataSource)
     */

    // Where did I click? Students or Staff? It'll tell my repository which data to fetch
    private val whichOption = MutableLiveData<String>()
    fun setOption(option: String){
        whichOption.value = option
    }

    // This data will be listened from the UI
    val fetchStudentsList = whichOption.distinctUntilChanged().switchMap {whichOption ->
        liveData(Dispatchers.IO){
            emit(Resource.Loading())
            try {
                emit(repository.getStudents(whichOption))
            }catch (e: Exception){
                emit(Resource.Failure(e))
            }
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