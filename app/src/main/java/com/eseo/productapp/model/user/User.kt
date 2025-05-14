package com.eseo.productapp.model.user


import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("email")
    val userEmail: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("username")
    val username: String,
)














