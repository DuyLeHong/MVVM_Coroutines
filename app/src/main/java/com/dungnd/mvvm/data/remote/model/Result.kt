package com.dungnd.mvvm.data.remote.model

import com.google.gson.annotations.SerializedName

data class Result<T>(
    @SerializedName(value = "results", alternate = ["top"])
    val results: List<T> = listOf()
)