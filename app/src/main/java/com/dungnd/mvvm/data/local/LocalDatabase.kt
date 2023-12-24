package com.dungnd.mvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dungnd.mvvm.data.local.dao.FavouriteQuoteDao
import com.dungnd.mvvm.data.local.dao.ItemDao
import com.dungnd.mvvm.data.local.model.FavouriteQuote
import com.dungnd.mvvm.data.local.model.Item

@Database(
    entities = [FavouriteQuote::class, Item::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun favouriteQuoteDao(): FavouriteQuoteDao
    abstract fun itemDao(): ItemDao
}