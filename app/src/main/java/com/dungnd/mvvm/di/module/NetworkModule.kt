package com.dungnd.mvvm.di.module

import com.dungnd.mvvm.data.remote.NetworkInterceptor
import com.dungnd.mvvm.data.remote.service.AnimeService
import com.dungnd.mvvm.data.remote.service.MangaService
import com.dungnd.mvvm.util.AppConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class NetworkModule {
    companion object {
        private const val BASE_URL_NEW = "https://jsonplaceholder.typicode.com/"
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_NEW)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAnimeService(retrofit: Retrofit): AnimeService =
        retrofit.create(AnimeService::class.java)

    @Singleton
    @Provides
    fun provideMangaService(retrofit: Retrofit): MangaService =
        retrofit.create(MangaService::class.java)

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(NetworkInterceptor())
            .connectTimeout(AppConfig.Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(AppConfig.Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}