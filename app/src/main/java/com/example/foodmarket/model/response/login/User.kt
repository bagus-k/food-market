package com.example.foodmarket.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @field:SerializedName("profile_photo_url")
    val profilePhotoUrl: String? = null,

    @Expose
    @field:SerializedName("address")
    val address: String? = null,

    @Expose
    @field:SerializedName("city")
    val city: String? = null,

    @Expose
    @field:SerializedName("roles")
    val roles: String? = null,

    @Expose
    @field:SerializedName("houseNumber")
    val houseNumber: String? = null,

    @Expose
    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @Expose
    @field:SerializedName("email_verified_at")
    val emailVerifiedAt: Any? = null,

    @Expose
    @field:SerializedName("current_team_id")
    val currentTeamId: Any? = null,

    @Expose
    @field:SerializedName("phoneNumber")
    val phoneNumber: String? = null,

    @Expose
    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @Expose
    @field:SerializedName("name")
    val name: String? = null,

    @Expose
    @field:SerializedName("id")
    val id: Int? = null,

    @Expose
    @field:SerializedName("profile_photo_path")
    val profilePhotoPath: Any? = null,

    @Expose
    @field:SerializedName("two_factor_confirmed_at")
    val twoFactorConfirmedAt: Any? = null,

    @Expose
    @field:SerializedName("email")
    val email: String? = null
)
