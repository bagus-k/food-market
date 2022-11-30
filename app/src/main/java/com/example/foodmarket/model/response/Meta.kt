package com.example.foodmarket.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meta(

    @Expose
    @field:SerializedName("code")
    val code: Int? = null,

    @Expose
    @field:SerializedName("message")
    val message: String? = null,

    @Expose
    @field:SerializedName("status")
    val status: String? = null
)
