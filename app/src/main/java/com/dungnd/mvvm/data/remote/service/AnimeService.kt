package com.dungnd.mvvm.data.remote.service

import com.dungnd.mvvm.data.remote.model.Photo
import retrofit2.http.GET

interface AnimeService {

    @GET("photos")
    suspend fun getAllPhoto(): List<Photo>
}