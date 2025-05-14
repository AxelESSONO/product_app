package com.eseo.productapp.model.repository

import android.util.Log
import com.eseo.productapp.model.service.UserApi
import com.eseo.productapp.model.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor (private val userApi: UserApi) {

    fun getUsersFlow(): Flow<List<User>> = flow {
        emit(userApi.getUserResponse())
    }.catch { e ->
        Log.e("UserRepository", "Error fetching users", e)
        emit(emptyList())
    }
}