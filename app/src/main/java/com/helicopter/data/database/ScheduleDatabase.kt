package com.helicopter.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.helicopter.data.database.dao.*
import com.helicopter.data.database.entities.*

@Database(
    entities = [EmployeeEntity::class, StudentGroupEntity::class, LastUpdateEntity::class,
        ScheduleModelEntity::class], version = 1, exportSchema = false
)
abstract class ScheduleDatabase : RoomDatabase() {
    abstract val studentGroupDao: StudentGroupDao

    abstract val scheduleDao: ScheduleDao

    abstract val employeeDao: EmployeeDao

    abstract val specialityDao: SpecialityDao

    abstract val facultyDao: FacultyDao

    abstract val auditoryDao: AuditoryDao

}

@Volatile
private lateinit var INSTANCE: ScheduleDatabase

fun getInstance(context: Context): ScheduleDatabase {
    if (!::INSTANCE.isInitialized) {
        synchronized(ScheduleDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ScheduleDatabase::class.java,
                    "schedule"
                ).build()
            }
        }
    }
    return INSTANCE
}


