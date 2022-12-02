package com.example.foodmarket.model.response.transaction

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(

    @Expose
    @field:SerializedName("total")
    val total: Int? = null,

    @Expose
    @field:SerializedName("payment_url")
    val paymentUrl: String? = null,

    @Expose
    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @Expose
    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @Expose
    @field:SerializedName("user_id")
    val userId: Int? = null,

    @Expose
    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @Expose
    @field:SerializedName("id")
    val id: Int? = null,

    @Expose
    @field:SerializedName("food_id")
    val foodId: Int? = null,

    @Expose
    @field:SerializedName("deleted_at")
    val deletedAt: String? = null,

    @Expose
    @field:SerializedName("user")
    val user: User? = null,

    @Expose
    @field:SerializedName("food")
    val food: Food? = null,

    @Expose
    @field:SerializedName("status")
    val status: String? = null
): Parcelable
