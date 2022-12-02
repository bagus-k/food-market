package com.example.foodmarket.model.response.checkout

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Food(

    @Expose
    @field:SerializedName("picturePath")
    val picturePath: String? = null,

    @Expose
    @field:SerializedName("types")
    val types: String? = null,

    @Expose
    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @Expose
    @field:SerializedName("rate")
    val rate: Int? = null,

    @Expose
    @field:SerializedName("price")
    val price: Int? = null,

    @Expose
    @field:SerializedName("name")
    val name: String? = null,

    @Expose
    @field:SerializedName("description")
    val description: String? = null,

    @Expose
    @field:SerializedName("ingredients")
    val ingredients: String? = null,

    @Expose
    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @Expose
    @field:SerializedName("id")
    val id: Int? = null,

    @Expose
    @field:SerializedName("deletedAt")
    val deletedAt: Any? = null
)