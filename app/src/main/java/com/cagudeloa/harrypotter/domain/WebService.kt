package com.cagudeloa.harrypotter.domain

import com.cagudeloa.harrypotter.data.model.Student
import retrofit2.http.GET

interface WebService {

    // What to search on the server? :
    @GET("characters")
    suspend fun getStudents(): List<Student>

}