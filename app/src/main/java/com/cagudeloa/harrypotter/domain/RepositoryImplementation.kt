package com.cagudeloa.harrypotter.domain

import com.cagudeloa.harrypotter.data.DataSource
import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.data.model.Staff
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.vo.Resource

class RepositoryImplementation(private val dataSource: DataSource): Repository {
    override fun getStudents(): Resource<List<Student>> {
        return dataSource.generateStudentsList
    }

    override fun getStaff(): Resource<List<Staff>> {
        return dataSource.generateStaffList
    }

    override fun getHouse(): Resource<List<House>> {
        return dataSource.generateHouseList
    }
}