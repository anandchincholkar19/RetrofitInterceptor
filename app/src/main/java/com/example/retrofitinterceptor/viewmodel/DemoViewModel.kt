package com.example.retrofitinterceptor.viewmodel

import android.accounts.NetworkErrorException
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofitinterceptor.model.Todo
import com.example.retrofitinterceptor.repository.RetrofitRepository
import com.example.retrofitinterceptor.webservicecommunication.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DemoViewModel(application: Application) : AndroidViewModel(application) {

    private val todoMutableData = MutableLiveData<List<Todo>>()
    val todoLiveData:LiveData<List<Todo>> = todoMutableData

    private val errorMessageMutableData = MutableLiveData<String>()
    val errorMessageLiveData = errorMessageMutableData

    private val progressMutableData = MutableLiveData<Boolean>()
    val progressLiveData = progressMutableData

    fun getTodoListFromRepository(){

        CoroutineScope(Dispatchers.IO).launch{

            when(val result = RetrofitRepository.getUserList() ){
                 is Result.Success -> todoMutableData.postValue(result.data)
                 is Result.Error -> errorMessageMutableData.postValue(result.exception.message)
            }
        }
    }
}