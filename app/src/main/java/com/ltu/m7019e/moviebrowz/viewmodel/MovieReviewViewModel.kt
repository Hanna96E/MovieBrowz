package com.ltu.m7019e.moviebrowz.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ltu.m7019e.moviebrowz.database.MovieDatabaseDao
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieReview
import com.ltu.m7019e.moviebrowz.model.MovieVideo
import com.ltu.m7019e.moviebrowz.network.*
import kotlinx.coroutines.launch

class MovieReviewViewModel(
    private val movieDatabaseDao: MovieDatabaseDao,
    application: Application,
    movie: Movie
) : AndroidViewModel(application) {

    private val _dataFetchStatusReviews = MutableLiveData<DataFetchStatus>()
    val dataFetchStatusReviews: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatusReviews
        }

    private val _dataFetchStatusVideos = MutableLiveData<DataFetchStatus>()
    val dataFetchStatusVideos: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatusVideos
        }

    private val _movieReviewList = MutableLiveData<List<MovieReview>>()
    val movieReviewList: LiveData<List<MovieReview>>
        get() {
            return _movieReviewList
        }

    private val _movieVideoList = MutableLiveData<List<MovieVideo>>()
    val movieVideoList: LiveData<List<MovieVideo>>
        get() {
            return _movieVideoList
        }

    private val _navigateToMovieDetail = MutableLiveData<Movie?>()
    val navigateToMovieDetail: MutableLiveData<Movie?>
        get() {
            return _navigateToMovieDetail
        }

    private val _videoLink = MutableLiveData<String>()
    val videoLink: MutableLiveData<String>
        get() {
            return _videoLink
        }

    init{}

    fun getReviews(movie: Movie){
        viewModelScope.launch {
            try {
                val movieReviewResponse: MovieReviewResponse =
                    TMDBApi.movieListRetrofitService.getMovieReviews(movie.id)
                _movieReviewList.value = movieReviewResponse.results
                _dataFetchStatusReviews.value = DataFetchStatus.DONE
            } catch (e: Exception) {
                _dataFetchStatusReviews.value = DataFetchStatus.ERROR
                _movieReviewList.value = arrayListOf()
            }
        }
    }

    fun getVideos(movie: Movie){
        viewModelScope.launch {
            try {
                val movieVideoResponse: MovieVideoResponse =
                    TMDBApi.movieListRetrofitService.getMovieVideos(movie.id)
                _movieVideoList.value = movieVideoResponse.results
                _dataFetchStatusVideos.value = DataFetchStatus.DONE
            } catch (e: Exception) {
                _dataFetchStatusVideos.value = DataFetchStatus.ERROR
                _movieVideoList.value = arrayListOf()
            }
        }
    }

    fun onVideoListItemClicked(movieVideo: MovieVideo) {
        _videoLink.value = movieVideo.getVideoLink(movieVideo.site, movieVideo.key)
    }
}
