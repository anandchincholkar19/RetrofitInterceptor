package com.example.retrofitinterceptor.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Todo(
    val id: String?,
    val name: String?,
    val description: String?,
    val html_url: String?
)