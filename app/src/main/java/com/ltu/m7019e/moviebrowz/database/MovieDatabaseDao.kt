package com.ltu.m7019e.moviebrowz.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ltu.m7019e.moviebrowz.model.Genre
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieDetail

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
    /*@Insert
    suspend fun insert(genre: Genre)

    @Delete
    suspend fun delete(genre: Genre)

    @Query("SELECT name from genres WHERE id = :id")
    suspend fun getGenreName(id: Long): String*/
}