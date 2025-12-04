package com.example.ap2_kotlin.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ap2_kotlin.data.dao.PersonagemDao
import com.example.ap2_kotlin.data.entity.PersonagensPoke

@Database(entities = [PersonagensPoke::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personagemDao(): PersonagemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "personagens_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}