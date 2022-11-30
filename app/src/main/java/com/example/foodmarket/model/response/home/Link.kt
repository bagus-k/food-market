package com.example.foodmarket.model.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Link(

    @Expose
    @field:SerializedName("active")
    val active: Boolean? = null,

    @Expose
    @field:SerializedName("label")
    val label: String? = null,

    @Expose
    @field:SerializedName("url")
    val url: Any? = null
)