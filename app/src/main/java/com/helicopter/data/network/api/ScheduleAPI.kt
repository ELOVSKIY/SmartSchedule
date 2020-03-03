package com.helicopter.data.network.api

import com.helicopter.data.network.remote.response.ScheduleResponse
import retrofit2.http.*

interface ScheduleAPI {

    //CHECKED
    @GET("studentGroup/schedule")
    suspend fun fetchGroupScheduleById(
        @Query("id") groupId: Long
    ): ScheduleResponse

    //CHECKED
    @FormUrlEncoded
    @GET("studentGroup/schedule")
    suspend fun fetchGroupScheduleByGroupName(
        @Query("studentGroup") studentGroup: String
    ): ScheduleResponse

    //CHECKED
    @GET("portal/employeeSchedule")
    suspend fun fetchEmployeeScheduleById(
        @Query("employeeId") employeeId: Long
    ): ScheduleResponse
}