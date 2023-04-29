package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movieGenres", primaryKeys = ["movieId", "genreId"])
data class MovieGenre (

    @ColumnInfo(name = "movieId")
    var movieId: Long,

    @ColumnInfo(name = "genreId")
    var genreId: Long

): Parcelable