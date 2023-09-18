package com.example.paging3andcaching.caching

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key")
data class RemoteKeys(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    val movieID: Int,
    val prevKey: Int?,
    val currentPage: Int,
    val nextKey: Int?,
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)


/*When remote keys are not directly associated with list items, it is best to store them in a separate table
in the local database. While this can be done in the Movie table, creating a new table for the next and
previous remote keys associated with a Movie allows us to have a better separation of concerns.*/

