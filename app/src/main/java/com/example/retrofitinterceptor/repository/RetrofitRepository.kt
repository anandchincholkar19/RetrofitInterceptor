package com.example.retrofitinterceptor.repository

import com.example.retrofitinterceptor.model.Todo
import com.example.retrofitinterceptor.webservicecommunication.Result
import com.example.retrofitinterceptor.webservicecommunication.RetrofitBuilder

object RetrofitRepository {
    private var cachedRepos: List<Todo> ?= null

    suspend fun getUserList(): Result<List<Todo>?> {
        return if (cachedRepos == null) {
            val todoList = RetrofitBuilder.apiService.getUsers()
            when {
                todoList is Result.Success -> cachedRepos = todoList.data
                else -> cachedRepos = null
            }
            return todoList
        } else {
            Result.Success(cachedRepos)
        }
    }

}

