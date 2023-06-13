package com.example.errorhandling.data

import com.example.errorhandling.domain.MyRespository
import com.example.errorhandling.util.Resource
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl: MyRespository {
    override suspend fun submitEmail(email: String): Resource<Unit> {
        // some API fetch calls
        delay(500)
        return if (Random.nextBoolean()){
            Resource.Success(Unit)
        } else {
            if(Random.nextBoolean()) {
                Resource.Error("Server Error")
            } else {
                Resource.Error("Not Authenticated")
            }
        }
    }
}