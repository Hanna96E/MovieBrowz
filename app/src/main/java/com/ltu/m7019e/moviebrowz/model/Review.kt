package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "reviews")
data class Review (
    val review: String
    ) : Parcelable