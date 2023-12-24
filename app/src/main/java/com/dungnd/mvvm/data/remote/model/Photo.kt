package com.dungnd.mvvm.data.remote.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("albumId")
    val albumId: Long = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String = ""
)