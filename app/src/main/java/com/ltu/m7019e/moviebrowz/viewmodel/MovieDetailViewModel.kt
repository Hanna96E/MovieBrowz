package com.ltu.m7019e.moviebrowz.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ltu.m7019e.moviebrowz.database.MovieDatabaseDao
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieDetail
import com.ltu.m7019e.moviebrowz.network.DataFetchStatus
import com.ltu.m7019e.moviebrowz.network.MovieDetailResponse
import com.ltu.m7019e.moviebrowz.network.TMDBApi
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieDatabaseDao: MovieDatabaseDao,
    application: Application,
    movie: Movie
) : AndroidViewModel(application){

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() {
            return _isFavorite
        }

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() {
            return _movieDetail
        }

    private val _dataFetchStatus = MutableLiveData<DataFetchStatus>()
    val dataFetchStatus: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatus
        }

    init {
        setIsFavorite(movie)
    }

    private fun setIsFavorite(movie: Movie) {
        viewModelScope.launch {
            _isFavorite.value = movieDatabaseDao.isFavorite(movie.id)
        }
    }

    fun getMovieDetails(movie: Movie) {
        viewModelScope.launch {
            try {
                val movieDetailResponse: MovieDetailResponse =
                    TMDBApi.movieListRetrofitService.getMovieDetails(movie.id)
                _movieDetail.value = MovieDetail(movie.id, movieDetailResponse.imdbId, movieDetailResponse.homepage)
                _dataFetchStatus.value = DataFetchStatus.DONE
            } catch (e: Exception) {
                _dataFetchStatus.value = DataFetchStatus.ERROR
                try {
                    _movieDetail.value = movieDatabaseDao.getMovieDetail(movie.id)
                } catch (e: Exception){
                    _movieDetail.value = MovieDetail(0, "", "")
                }
            }
        }
    }

    fun onSaveMovieButtonClicked(movie: Movie, movieDetail: MovieDetail) {
        viewModelScope.launch {
            movieDatabaseDao.insert(movie)
            movieDatabaseDao.insert(movieDetail)
            setIsFavorite(movie)
        }
    }

    fun onRemoveMovieButtonClicked(movie: Movie, movieDetail: MovieDetail) {
        viewModelScope.launch {
            movieDatabaseDao.delete(movie)
            movieDatabaseDao.delete(movieDetail)
            setIsFavorite(movie)
        }
    }
}