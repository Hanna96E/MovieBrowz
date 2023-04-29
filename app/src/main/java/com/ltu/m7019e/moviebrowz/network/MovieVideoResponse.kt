package com.ltu.m7019e.moviebrowz.network

import com.ltu.m7019e.moviebrowz.model.MovieVideo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieVideoResponse {
    @Json(name = "results")
    var results: List<MovieVideo> = listOf()
}