package com.cagudeloa.harrypotter.domain

import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.vo.Resource

interface Repository {
    /**
     * These methods will return me a list of [Student|Staff|House]
     */
    suspend fun getStudents(): Resource<List<Student>>
    // This one will not really come from API as two above
    fun getHouse(): Resource<List<House>>
}