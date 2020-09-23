package com.cagudeloa.harrypotter.data

import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.vo.Resource
import com.cagudeloa.harrypotter.vo.RetrofitClient

class DataSource {

    val generateHouseList = Resource.Success(
        listOf(
            House(
                "Gryffindor", "Lion", "Fire", "Godric Gryffindor", "Nearly-Headless Nick", "Gryffindor Tower",
                listOf("courage", "bravery", "nerve", "chivalry"),
                listOf("scarlet", "gold")
            ),
            House(
                "Slytherin", "Serpent", "Water", "Salazar Slytherin", "Bloody Baron", "Slytherin Dungeon",
                listOf("ambition", "cunning", "leadership", "resourcefulness"),
                listOf("green", "silver")
            ),
            House(
                "Hufflepuff", "Badger", "Earth", "Fat Friar", "Rowena Ravenclaw", "Hufflepuff Basement",
                listOf("hard work", "patience", "justice", "loyalty"),
                listOf("yellow", "black")
            ),
            House(
                "Ravenclaw", "Eagle", "Air", "Helga Hufflepuff", "Grey Lady", "Ravenclaw Tower",
                listOf("intelligence", "learning", "wisdom", "wit"),
                listOf("blue", "bronze")
            )
        )
    )

    suspend fun getStudentList(whichPerson: String): Resource<List<Student>> {
        val value = RetrofitClient.webService.getStudents(whichPerson)
        return Resource.Success(value)
    }

}