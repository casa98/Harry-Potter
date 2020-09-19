package com.cagudeloa.harrypotter.domain

import com.cagudeloa.harrypotter.data.model.Student
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    // What to search on the server? :
    @GET("characters/{whichOption}")
    suspend fun getStudents(@Path("whichOption") whichOption: String): List<Student>
    // The parameter above will be 'students' or 'staff'
}