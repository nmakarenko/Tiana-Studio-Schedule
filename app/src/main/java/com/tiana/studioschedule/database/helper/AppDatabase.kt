package com.tiana.studioschedule.database.helper

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.tiana.studioschedule.database.dao.MemberDao
import com.tiana.studioschedule.database.model.Member

@Database(entities = [Member::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memberDao(): MemberDao

    companion object {
        private const val DB_NAME = "tiana_studio.db"
        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, DB_NAME)
                            .build()
                }
            }
            return instance
        }

        fun clearDatabase() {
            instance?.clearAllTables()
        }

        fun destroyInstance() {
            instance = null
        }
    }
}