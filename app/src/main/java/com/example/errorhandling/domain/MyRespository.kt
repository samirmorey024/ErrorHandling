package com.example.errorhandling.domain

import com.example.errorhandling.util.Resource

interface MyRespository  {

    suspend fun submitEmail(email: String): Resource<Unit>

}