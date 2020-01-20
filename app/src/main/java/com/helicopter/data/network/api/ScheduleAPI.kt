package com.helicopter.data.network.api

import com.helicopter.data.network.remote.response.groupSchedulerResponse.GroupScheduleResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ScheduleAPI {

    @GET("studentGroup/schedule")
    suspend fun fetchGroupScedulerById(
        @Field("id") groupId: Int
    ): GroupScheduleResponse

    @GET("studentGroup/schedule")
    suspend fun fetchSchedulerByStudentGroup(
        @Query("studentGroup") studentGroup: Int
    ): GroupScheduleResponse
}