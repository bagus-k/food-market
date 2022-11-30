package com.example.foodmarket.model.request

import android.net.Uri
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class RegisterRequest (

    @Expose
    @field:SerializedName("name")
    val name: String? = null,

    @Expose
    @field:SerializedName("email")
    val email: String? = null,

    @Expose
    @field:SerializedName("password")
    val password: String? = null,

    @Expose
    @field:SerializedName("password_confirmation")
    val password_confirmation: String? = null,

    @Expose
    @field:SerializedName("address")
    var address: String? = null,

    @Expose
    @field:SerializedName("city")
    var city: String? = null,

    @Expose
    @field:SerializedName("houseNumber")
    var houseNumber: String? = null,

    @Expose
    @field:SerializedName("phoneNumber")
    var phoneNumber: String? = null,

    @Expose
    @field:SerializedName("profile_photo_path")
    val profilePhotoPath: Uri? = null,

//    @Expose
//    @field:SerializedName("created_at")
//    val createdAt: String? = null,
//
//    @Expose
//    @field:SerializedName("email_verified_at")
//    val emailVerifiedAt: Any? = null,
//
//    @Expose
//    @field:SerializedName("current_team_id")
//    val currentTeamId: Any? = null,
//
//    @Expose
//    @field:SerializedName("roles")
//    val roles: String? = null,
//
//    @Expose
//    @field:SerializedName("updated_at")
//    val updatedAt: String? = null,
//
//    @Expose
//    @field:SerializedName("id")
//    val id: Int? = null,
//
//    @Expose
//    @field:SerializedName("two_factor_confirmed_at")
//    val twoFactorConfirmedAt: Any? = null,

) : Parcelable