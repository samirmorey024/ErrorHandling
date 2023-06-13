package com.example.errorhandling.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.errorhandling.domain.SubmitEmailUseCase
import com.example.errorhandling.util.Resource
import kotlinx.coroutines.launch

class MyViewModel(private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()): ViewModel() {

    val error = MutableLiveData<String?>("")

    fun submitEmail(email: String) {
        viewModelScope.launch {
            val result = submitEmailUseCase.execute(email)
            when(result) {
                is Resource.Success -> {
                    error
                }
                is Resource.Error -> {
                    error.postValue(result.message)
                }}
        }
    }
}