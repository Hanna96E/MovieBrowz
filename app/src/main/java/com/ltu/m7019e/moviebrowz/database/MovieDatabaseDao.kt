package com.ltu.m7019e.moviebrowz.database

import androidx.room.*
import com.ltu.m7019e.moviebrowz.model.Genre
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieDetail
import com.ltu.m7019e.moviebrowz.model.MovieGenre

@Dao
interface MovieDatabaseDao {
    // Movie
    @Insert
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * from movies ORDER BY id ASC")
    suspend fun getAllMovies(): List<Movie>

    @Query("SELECT EXISTS(SELECT * from movies WHERE id = :id)")
    suspend fun isFavorite(id: Long): Boolean

    // MovieDetail
    @Insert
    suspend fun insert(movieDetail: MovieDetail)

    @Delete
    suspend fun delete(movieDetail: MovieDetail)

    @Query("SELECT * from movieDetails WHERE id = :id")
    suspend fun getMovieDetail(id: Long): MovieDetail

    // Genre
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genre: Genre)

    @Delete
    suspend fun delete(genre: Genre)

    @Query("SELECT * from genres WHERE id = :id")
    suspend fun getGenre(id: Long): Genre

    @Insert
    suspend fun insert(movieGenre: MovieGenre)

    @Delete
    suspend fun delete(movieGenre: MovieGenre)

    @Query("SELECT * from movieGenres WHERE movieId = :movieId")
    suspend fun getMovieGenresFromMovieId(movieId: Long): List<MovieGenre>

    @Query("SELECT * from movieGenres WHERE genreId = :genreId")
    suspend fun getMovieGenresFromGenreId(genreId: Long): List<MovieGenre>
}