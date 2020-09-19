package com.cagudeloa.harrypotter.data

import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.data.model.Staff
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.vo.Resource

class DataSource {

    /**
     * Here is where I look for the info from the server, local data for now
     */

    private val generateStudentsList = listOf(
        Student("31-07-1980", "male", "Gryffindor", "http://hp-api.herokuapp.com/images/harry.jpg", "Harry Potter", "stag"),
        Student("19-09-1979", "female", "Gryffindor", "http://hp-api.herokuapp.com/images/hermione.jpeg", "Hermione Granger", "otter"),
        Student("01-03-1980", "male", "Gryffindor", "http://hp-api.herokuapp.com/images/hermione.jpeg", "Ron Weasley", "Jack Russell terrier")
    )

    private val generateStaffList = listOf(
        Staff("31-07-1980", "male", "Gryffindor", "http://hp-api.herokuapp.com/images/harry.jpg", "Harry Potter", "stag"),
        Staff("19-09-1979", "female", "Gryffindor", "http://hp-api.herokuapp.com/images/hermione.jpeg", "Hermione Granger", "otter")
    )

    private val generateHouseList = listOf(
        House("", "Gryffindor", "A nice house"),
        House("", "Slytherin", "An also nice house"),
        House("", "Hufflepuff", "Well... no comments"),
        House("", "Ravenclaw", "A regular house")
    )

    fun getStudentsList(): Resource<List<Student>>{
        return Resource.Success(generateStudentsList)
    }

    fun getStaffList(): Resource<List<Staff>>{
        return Resource.Success(generateStaffList)
    }

    fun getHouseList(): Resource<List<House>>{
        return Resource.Success(generateHouseList)
    }

}