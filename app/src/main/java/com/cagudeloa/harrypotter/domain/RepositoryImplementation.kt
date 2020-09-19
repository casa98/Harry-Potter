package com.cagudeloa.harrypotter.domain

import com.cagudeloa.harrypotter.data.DataSource
import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.vo.Resource

class RepositoryImplementation(private val dataSource: DataSource): Repository {
    override suspend fun getStudents(): Resource<List<Student>> {
        return dataSource.getStudentList()
    }

    override fun getHouse(): Resource<List<House>> {
        return dataSource.generateHouseList
    }
}