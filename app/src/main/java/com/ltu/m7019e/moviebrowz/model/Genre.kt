package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "genres")
data class Genre (
        @PrimaryKey()
        @Json(name = "id")
        var id: Int,

        @ColumnInfo(name = "name")
        @Json(name = "name")
        var name: String
        ): Parcelable
{
        override fun toString(): String = name
}