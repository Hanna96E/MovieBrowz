package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie (
        var id: Int,
        var title:String,
        var posterPath:String,
        var backdropPath:String,
        var releaseDate:String,
        var overview:String,
        var detail: MovieDetail
        ) : Parcelable

// create objects inside this class for e.g., genres