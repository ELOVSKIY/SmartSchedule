package com.helicopter.data.network.api

import com.helicopter.data.network.models.*
import retrofit2.http.GET

interface ListApi {

    //CHECKED
    @GET("groups")
    suspend fun fetchGroupList(): List<StudentGroup>

    //CHECKED
    @GET("employees")
    suspend fun fetchEmployeeList(): List<Employee>

    //CHECKED
    @GET("faculties")
    suspend fun fetchFacultyList(): List<Faculty>

    //CHECKED
    @GET("department")
    suspend fun fetchDepartmentList(): List<Department>

    //CHECKED
    @GET("specialities")
    suspend fun fetchSpecialityList(): List<Speciality>

    //CHECKED
    @GET("auditory")
    suspend fun fetchAuditoryList(): List<Auditory>
}