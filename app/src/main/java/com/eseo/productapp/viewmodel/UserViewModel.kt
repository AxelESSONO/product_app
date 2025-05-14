package com.eseo.productapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eseo.productapp.model.data.Product
import com.eseo.productapp.model.repository.UserRepository
import com.eseo.productapp.model.user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor (
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val products: StateFlow<List<User>> = _users

    init {
        getAllUsers()
    }

    private fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.getUsersFlow().collectLatest {
            _users.value = it
        }
    }

}