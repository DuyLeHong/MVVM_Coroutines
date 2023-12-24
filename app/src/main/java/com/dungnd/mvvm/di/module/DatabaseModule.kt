package com.dungnd.mvvm.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.dungnd.mvvm.data.local.AppPreferences
import com.dungnd.mvvm.data.local.LocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(appContext: Context): LocalDatabase {
        return Room
            .databaseBuilder(
                appContext.applicationContext,
                LocalDatabase::class.java,
                "localDb"
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFavouriteQuoteDao(db: LocalDatabase) =
        db.favouriteQuoteDao()

    @Singleton
    @Provides
    fun provideItemDao(db: LocalDatabase) =
        db.itemDao()

    @Singleton
    @Provides
    fun provideAppPreference(appContext: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(appContext)
    }

}