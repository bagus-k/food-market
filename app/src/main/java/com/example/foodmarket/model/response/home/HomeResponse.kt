package com.example.foodmarket.model.response.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeResponse(

	@Expose
	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@Expose
	@field:SerializedName("data")
	val data: List<Data>,

	@Expose
	@field:SerializedName("last_page")
	val lastPage: Int? = null,

	@Expose
	@field:SerializedName("next_page_url")
	val nextPageUrl: Any? = null,

	@Expose
	@field:SerializedName("prev_page_url")
	val prevPageUrl: Any? = null,

	@Expose
	@field:SerializedName("first_page_url")
	val firstPageUrl: String? = null,

	@Expose
	@field:SerializedName("path")
	val path: String? = null,

	@Expose
	@field:SerializedName("total")
	val total: Int? = null,

	@Expose
	@field:SerializedName("last_page_url")
	val lastPageUrl: String? = null,

	@Expose
	@field:SerializedName("from")
	val from: Int? = null,

	@Expose
	@field:SerializedName("links")
	val links: List<Link?>? = null,

	@Expose
	@field:SerializedName("to")
	val to: Int? = null,

	@Expose
	@field:SerializedName("current_page")
	val currentPage: Int? = null
)



