package com.eseo.productapp.model.service

import com.eseo.productapp.model.user.User
import retrofit2.http.GET

interface UserApi {
    
    @GET("users")
    suspend fun getUserResponse(): List<User>

}