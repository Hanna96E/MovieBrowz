package com.ltu.m7019e.moviebrowz.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ltu.m7019e.moviebrowz.model.*

@Dao
interface MovieDatabaseDao {
    // Movie
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movieList: List<Movie>)

    @Query("DELETE FROM movies")
    fun deleteAllMovies()

    @Query("SELECT * from movies ORDER BY id ASC")
    fun getAllMovies(): LiveData<List<Movie>>

    // MovieDetail
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieDetail: MovieDetail)

    @Delete
    suspend fun delete(movieDetail: MovieDetail)

    @Query("SELECT * from movieDetails WHERE id = :id")
    fun getMovieDetail(id: Long): LiveData<MovieDetail>

    @Query("SELECT * from movieDetails ORDER BY id ASC")
    fun getAllMovieDetails(): LiveData<List<MovieDetail>>

    // Genre
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genre: Genre)

    @Delete
    suspend fun delete(genre: Genre)

    @Query("SELECT * from genres WHERE id = :id")
    fun getGenre(id: Long): LiveData<Genre>

    @Insert
    suspend fun insert(movieGenre: MovieGenre)

    @Delete
    suspend fun delete(movieGenre: MovieGenre)

    @Query("SELECT * from movieGenres WHERE movieId = :movieId")
    fun getMovieGenresFromMovieId(movieId: Long): LiveData<List<MovieGenre>>

    @Query("SELECT * from movieGenres WHERE genreId = :genreId")
    fun getMovieGenresFromGenreId(genreId: Long): List<MovieGenre>

    // cached movie
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cachedMovie: CachedMovie)

    @Delete
    fun delete(cachedMovie: CachedMovie)

    @Query("DELETE FROM cachedMovies")
    fun deleteAllCachedMovies()

    @Query("SELECT * from cachedMovies ORDER BY id ASC")
    fun getAllCachedMovies(): List<CachedMovie>

    // saved movie
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(savedMovie: SavedMovie)

    @Delete
    fun delete(savedMovie: SavedMovie)

    @Query("SELECT EXISTS(SELECT * from savedMovies WHERE id = :id)")
    suspend fun isFavorite(id: Long): Boolean

    @Query("SELECT * from savedMovies ORDER BY id ASC")
    fun getAllSavedMovies(): List<SavedMovie>
}