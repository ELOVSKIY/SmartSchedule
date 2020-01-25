package com.helicopter.data.network.api

import com.helicopter.data.network.remote.response.employeeScheduleResponse.EmployeeScheduleResponse
import com.helicopter.data.network.remote.response.groupSchedulerResponse.GroupScheduleResponse
import retrofit2.http.*

interface ScheduleAPI {

    //CHECKED
    @GET("studentGroup/schedule")
    suspend fun fetchGroupSceduleById(
        @Field("id") groupId: Int
    ): GroupScheduleResponse

    //CHECKED
    @GET("studentGroup/schedule")
    suspend fun fetchGroupScheduleByStudentGroup(
        @Query("studentGroup") studentGroup: Int
    ): GroupScheduleResponse

    //CHECKED
    @GET("portal/employeeSchedule")
    suspend fun fetchEployeeScheduleById(
        @Query("employeeId") employeeId: Int
    ): EmployeeScheduleResponse
}