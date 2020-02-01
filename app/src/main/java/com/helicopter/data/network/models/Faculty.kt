package com.helicopter.data.network.models

import com.helicopter.data.database.entities.FacultyEntity

data class Faculty(
    val abbrev: String,
    val id: Long,
    val name: String
)

fun List<Faculty>.asDatabaseEntities(): List<FacultyEntity>{
    return this.map {
        FacultyEntity(
            it.id,
            it.abbrev,
            it.name
        )
    }
}