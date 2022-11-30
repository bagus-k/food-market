package com.example.foodmarket.model.response
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wrapper<T>(

    @Expose
    @field:SerializedName("data")
    val data: T? = null,

    @Expose
    @field:SerializedName("meta")
    val meta: Meta? = null
)