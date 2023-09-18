package com.example.paging3andcaching.caching

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3andcaching.model.Movie

@Database(entities = [Movie::class, RemoteKeys::class], version = 1,)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
}