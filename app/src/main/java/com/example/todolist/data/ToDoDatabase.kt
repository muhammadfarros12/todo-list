package com.example.todolist.data

import android.content.Context
import androidx.room.*
import com.example.todolist.data.moduls.TodoData

@Database(entities = [TodoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): TodoData

    companion object{

        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context):ToDoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
