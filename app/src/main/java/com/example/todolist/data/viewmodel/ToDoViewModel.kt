package com.example.todolist.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.ToDoDatabase
import com.example.todolist.data.moduls.TodoData
import com.example.todolist.data.repository.ToDoRepository
//import com.example.todolist.data.ToDoDatabase
//import com.example.todolist.data.moduls.TodoData
//import com.example.todolist.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository

    private val getAllData: LiveData<List<TodoData>>

    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getAllData
    }

    fun inserData(todoData: TodoData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(todoData)
        }
    }

}
