package com.ltu.m7019e.moviebrowz.repository


import androidx.lifecycle.LiveData
import com.ltu.m7019e.moviebrowz.database.MovieDatabase
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.CachedMovie
import com.ltu.m7019e.moviebrowz.network.TMDBApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class MovieRepository(private val database: MovieDatabase) {

    var movies : LiveData<List<Movie>> = database.movieDatabaseDao.getAllMovies()

    suspend fun refreshMovies(movieListType: LiveData<MovieListType>) {
        withContext(Dispatchers.IO) {
            var movieList = listOf<Movie>()
            database.movieDatabaseDao.deleteAllMovies()
            if (movieListType.value == MovieListType.POPULAR || movieListType.value == MovieListType.TOP_RATED) {
                val cachedMovies = database.movieDatabaseDao.getAllCachedMovies()
                val cachedMovieType = if (cachedMovies.isNotEmpty()) cachedMovies[0].type else MovieListType.POPULAR
                val cachedMoviesAsMovies = cachedMovies.map { cachedMovie ->
                    Movie(
                        id = cachedMovie.id,
                        title = cachedMovie.title,
                        posterPath = cachedMovie.posterPath,
                        backdropPath = cachedMovie.backdropPath,
                        releaseDate = cachedMovie.releaseDate,
                        overview = cachedMovie.overview
                    )
                }

                try {
                    if(movieListType.value == MovieListType.POPULAR){
                        movieList = TMDBApi.movieListRetrofitService.getPopularMovies().results
                    } else if(movieListType.value == MovieListType.TOP_RATED){
                        movieList = TMDBApi.movieListRetrofitService.getTopRatedMovies().results
                    }
                    database.movieDatabaseDao.deleteAllCachedMovies()
                    movieList.forEach{movie ->
                        database.movieDatabaseDao.insert(movie)
                        database.movieDatabaseDao.insert(CachedMovie(
                            movie.id,
                            movie.title,
                            movie.posterPath,
                            movie.backdropPath,
                            movie.releaseDate,
                            movie.overview,
                            movieListType.value.toString()))
                    }
                } catch (networkError: IOException){
                    if(cachedMovieType == movieListType.value.toString()){
                        cachedMoviesAsMovies.forEach{movie ->
                            database.movieDatabaseDao.insert(movie)
                        }
                    }
                    throw networkError
                }
            } else {
                movieList = database.movieDatabaseDao.getAllSavedMovies().map { savedMovie ->
                    Movie(
                        id = savedMovie.id,
                        title = savedMovie.title,
                        posterPath = savedMovie.posterPath,
                        backdropPath = savedMovie.backdropPath,
                        releaseDate = savedMovie.releaseDate,
                        overview = savedMovie.overview
                    )
                }
                movieList.forEach{movie ->
                    database.movieDatabaseDao.insert(movie)
                }
            }
        }
    }
}