package com.ltu.m7019e.moviebrowz.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ltu.m7019e.moviebrowz.database.MovieDatabaseDao
import com.ltu.m7019e.moviebrowz.model.Genre
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieDetail
import com.ltu.m7019e.moviebrowz.model.MovieGenre
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

    private val _genreList = MutableLiveData<List<Genre>>()
    val genreList: LiveData<List<Genre>>
        get() {
            return _genreList
        }

    private val _genreString = MutableLiveData<String>()
    val genreString: LiveData<String>
        get() {
            return _genreString
        }

    private val _dataFetchStatus = MutableLiveData<DataFetchStatus>()
    val dataFetchStatus: LiveData<DataFetchStatus>
        get() {
            return _dataFetchStatus
        }

    private val _navigateToMovieReview = MutableLiveData<Movie?>()
    val navigateToMovieReview: MutableLiveData<Movie?>
        get() {
            return _navigateToMovieReview
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
                _genreList.value = movieDetailResponse.genres
                createGenreString()
                _dataFetchStatus.value = DataFetchStatus.DONE
            } catch (e: Exception) {
                _dataFetchStatus.value = DataFetchStatus.ERROR
                try {
                    _movieDetail.value = movieDatabaseDao.getMovieDetail(movie.id)
                    createGenreListFromMovieId(movie)
                } catch (e: Exception){
                    _movieDetail.value = MovieDetail(0, "", "")
                    _genreList.value = listOf(Genre(0, ""))
                }
            }
        }
    }

    fun onSaveMovieButtonClicked(movie: Movie, movieDetail: MovieDetail, genres:List<Genre>) {
        viewModelScope.launch {
            movieDatabaseDao.insert(movie)
            movieDatabaseDao.insert(movieDetail)
            genres.forEach{ genre ->
                movieDatabaseDao.insert(genre)
                movieDatabaseDao.insert(MovieGenre(movie.id,genre.id))
            }
            setIsFavorite(movie)
        }
    }

    fun onRemoveMovieButtonClicked(movie: Movie, movieDetail: MovieDetail, genres:List<Genre>) {
        viewModelScope.launch {
            movieDatabaseDao.delete(movie)
            movieDatabaseDao.delete(movieDetail)
            genres.forEach{ genre ->
                movieDatabaseDao.delete(MovieGenre(movie.id,genre.id))
            }
            setIsFavorite(movie)
        }
    }

    private fun createGenreListFromMovieId(movie: Movie){
        viewModelScope.launch {
            val genreIds = mutableListOf<Long>()
            val genreList = mutableListOf<Genre>()
            val movieGenres = movieDatabaseDao.getMovieGenresFromMovieId(movie.id)
            movieGenres.forEach{movieGenre: MovieGenre ->
                genreIds.add(movieGenre.genreId)
            }
            genreIds.forEach{genreId: Long ->
                genreList.add(movieDatabaseDao.getGenre(genreId))
            }
            _genreList.value = genreList
            createGenreString()
        }
    }

    private fun createGenreString(){
        viewModelScope.launch {
            val genreNames = mutableListOf<String>()
            genreList.value?.forEach{genre: Genre ->
                genreNames.add(genre.name)
            }
            _genreString.value = genreNames.joinToString(separator = " | ")
        }
    }
}