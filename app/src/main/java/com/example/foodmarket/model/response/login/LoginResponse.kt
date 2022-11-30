package com.example.foodmarket.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@Expose
	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@Expose
	@field:SerializedName("token_type")
	val tokenType: String? = null,

	@Expose
	@field:SerializedName("user")
	val user: User? = null
)
