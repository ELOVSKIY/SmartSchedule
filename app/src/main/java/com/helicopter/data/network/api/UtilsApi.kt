package com.helicopter.data.network.api

import com.helicopter.data.network.models.LastUpdateDate
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface UtilsApi {

    @GET("studentGroup/lastUpdateDate")
    suspend fun fetchLastScheduleUpdateByGroupId(
        @Field("id") groupId: Int
    ): LastUpdateDate

    @GET("studentGroup/lastUpdateDate")
    suspend fun fetchLastScheduleUpdateByStudentGroup(
        @Query("studentGroup") studentGroup: Int
    ): LastUpdateDate

    //CHECKED
    @GET("week")
    suspend fun fetchCurrentWeekNumb(): Int
}