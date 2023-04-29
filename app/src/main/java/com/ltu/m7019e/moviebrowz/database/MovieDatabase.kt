package com.ltu.m7019e.moviebrowz.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ltu.m7019e.moviebrowz.model.Genre
import com.ltu.m7019e.moviebrowz.model.Movie
import com.ltu.m7019e.moviebrowz.model.MovieDetail
import com.ltu.m7019e.moviebrowz.model.MovieGenre

@Database(entities = [Movie::class, MovieDetail::class, Genre::class, MovieGenre::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDatabaseDao: MovieDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "saved_movie_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}