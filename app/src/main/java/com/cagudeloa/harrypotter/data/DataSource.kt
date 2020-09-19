package com.cagudeloa.harrypotter.data

import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.vo.Resource
import com.cagudeloa.harrypotter.vo.RetrofitClient

class DataSource {

    val generateHouseList = Resource.Success(listOf(
        House("", "Gryffindor", "A nice house"),
        House("", "Slytherin", "An also nice house"),
        House("", "Hufflepuff", "Well... no comments"),
        House("", "Ravenclaw", "A regular house")
    ))

    suspend fun getStudentList(whichPerson: String): Resource<List<Student>>{
        val value = RetrofitClient.webService.getStudents(whichPerson)
        return Resource.Success(value)
    }

}