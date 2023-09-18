package com.example.paging3andcaching.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3andcaching.caching.MoviesDatabase
import com.example.paging3andcaching.database.MoviesApiService
import com.example.paging3andcaching.model.Movie
import com.example.paging3andcaching.remotemediator.MoviesRemoteMediator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

const val PAGE_SIZE = 20

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val moviesDatabase: MoviesDatabase,
): ViewModel() {
    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = 10,
                initialLoadSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                moviesDatabase.getMoviesDao().getMovies()
            },
            remoteMediator = MoviesRemoteMediator(
                moviesApiService,
                moviesDatabase,
            )
        ).flow
}

/*This is similar to creating a Pager from a simple network data source, but there are two things you must do differently:
Instead of passing a PagingSource constructor directly, you must provide the query method that returns a PagingSource object from the DAO.
You must provide an instance of your RemoteMediator implementation as the remoteMediator parameter.*/