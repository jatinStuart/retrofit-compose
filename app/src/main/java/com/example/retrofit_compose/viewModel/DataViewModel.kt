package com.example.retrofit_compose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_compose.model.Data
import com.example.retrofit_compose.network.ApiService
import kotlinx.coroutines.launch

class DataViewModel:ViewModel() {
    var dataResponse : List<Data> by mutableStateOf(listOf())
    private var errorMessage : String by mutableStateOf("")

    fun getDataList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val dataList = apiService.getData()
                dataResponse = dataList
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }

        }
    }

}