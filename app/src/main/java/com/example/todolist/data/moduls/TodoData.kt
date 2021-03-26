package com.example.todolist.data.moduls

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoData (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title: String,
    var priority: Priority,
    var description: String
)
