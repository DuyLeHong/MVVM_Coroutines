package com.dungnd.mvvm.data.local.dao

import androidx.room.*
import com.dungnd.mvvm.data.local.model.FavouriteQuote

@Dao
interface FavouriteQuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuote(quote: FavouriteQuote)

    @Query("select * from FavouriteQuote")
    suspend fun getAllQuotes(): List<FavouriteQuote>

    @Delete
    suspend fun removeFromFavourite(quote: FavouriteQuote)
}