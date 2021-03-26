package com.example.todolist.data.repository

import androidx.lifecycle.LiveData
import com.example.todolist.data.ToDoDao
import com.example.todolist.data.moduls.TodoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<TodoData>> = toDoDao.getAllData()

    suspend fun insertData(todoData: TodoData){
        toDoDao.insertData(todoData)
    }

}
