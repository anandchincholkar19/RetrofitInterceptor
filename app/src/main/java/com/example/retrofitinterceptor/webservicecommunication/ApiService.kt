package com.example.retrofitinterceptor.webservicecommunication

import com.example.retrofitinterceptor.model.Todo
import retrofit2.http.GET

interface ApiService {

    @GET("search/repositories?q=android+language:java+language:kotlin&sort=stars&order=desc")
    suspend fun getUsers():Result<List<Todo>>
}