package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ltu.m7019e.moviebrowz.utils.Constants.IMDB_BASE_URL
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movieDetails")
data class MovieDetail (
        @PrimaryKey
        @Json(name = "id")
        var id: Long = 0L,

        @ColumnInfo(name = "imdb_id")
        @Json(name = "imdb_id")
        var imdbId: String,

        @ColumnInfo(name = "homepage")
        @Json(name = "homepage")
        var homepage: String,

        ) : Parcelable
