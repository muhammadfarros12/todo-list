package com.example.todolist.data

import androidx.room.TypeConverter
import com.example.todolist.data.moduls.Priority

class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }

}
