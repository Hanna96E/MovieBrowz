package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetail (
        var id: Int,
        var imdbId: String,
        var homepage: String,
        var genres: List<Genre>
        ) : Parcelable