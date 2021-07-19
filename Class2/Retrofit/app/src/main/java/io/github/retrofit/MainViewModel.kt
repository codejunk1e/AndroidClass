package io.github.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    val items: MutableLiveData<List<Todo>> = MutableLiveData()

    fun getAllTodos(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val todos: List<Todo> = RetrofitProvider.service.getAllTodos()
                items.postValue(todos)
            }
        }catch (e: Exception){
            Log.e("ViewModel", e.message.toString())
        }

    }

}