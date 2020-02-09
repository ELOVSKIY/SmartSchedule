package com.helicopter.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "last_update")
data class LastUpdateEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "last_update_id")
    val lastUpdateId: Long,

    @ColumnInfo(name = "last_update_date")
    val lastUpdateDate: String
)