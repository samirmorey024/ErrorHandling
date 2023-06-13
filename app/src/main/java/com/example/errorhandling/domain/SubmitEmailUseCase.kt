package com.example.errorhandling.domain

import com.example.errorhandling.data.MyRepositoryImpl
import com.example.errorhandling.util.Resource

class SubmitEmailUseCase(private val repositoryImpl: MyRespository = MyRepositoryImpl()) {

    suspend fun execute(email: String): Resource<Unit> {
        if (!email.contains('@')) {
            return Resource.Error("That is not a valid email.")
        }
      return  repositoryImpl.submitEmail(email)
    }
}