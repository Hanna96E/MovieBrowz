package com.ltu.m7019e.moviebrowz.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.ltu.m7019e.moviebrowz.database.MovieDatabase
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.network.DataFetchStatus
import com.ltu.m7019e.moviebrowz.repository.MovieListType
import com.ltu.m7019e.moviebrowz.repository.MovieRepository
import com.ltu.m7019e.moviebrowz.worker.RefreshDataWorker
import kotlinx.coroutines.launch
import java.io.IOException

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    private val _dataFetchStatus = MutableLiveData<DataFetchStatus>()
    val dataFetchStatus: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatus
        }

    private val _movieListType = MutableLiveData<MovieListType>()
    private val movieListType: LiveData<MovieListType>
        get() {
            return _movieListType
        }

    private val movieRepository = MovieRepository(MovieDatabase.getInstance(application))
    var movieList = movieRepository.movies


    private val _navigateToMovieDetail = MutableLiveData<Movie?>()
    val navigateToMovieDetail: MutableLiveData<Movie?>
        get() {
            return _navigateToMovieDetail
        }


    private val workManager = WorkManager.getInstance(application)

    init {
        _movieListType.value = MovieListType.POPULAR
        refreshDataFromRepository()
        //getPopularMovies()
        _dataFetchStatus.value = DataFetchStatus.LOADING
    }


    fun refreshDataFromRepository() {
        viewModelScope.launch {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val workRequest: WorkRequest = OneTimeWorkRequestBuilder<RefreshDataWorker>()
                .setConstraints(constraints)
                .build()
            try {
                movieRepository.refreshMovies(movieListType)

                workManager.cancelAllWork()
                _dataFetchStatus.value = DataFetchStatus.DONE
            } catch (networkError: IOException) {
                if (movieList.value.isNullOrEmpty()) {
                    workManager.enqueue(workRequest)
                    _dataFetchStatus.value = DataFetchStatus.ERROR
                }
            }
        }
    }

    fun setMovieListType(movieListType: MovieListType){
        _movieListType.value = movieListType
    }

    fun onMovieListItemClicked(movie: Movie) {
        _navigateToMovieDetail.value = movie
    }

    fun onMovieDetailNavigated() {
        _navigateToMovieDetail.value = null
    }
}