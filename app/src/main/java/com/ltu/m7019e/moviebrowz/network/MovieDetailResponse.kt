package com.ltu.m7019e.moviebrowz.network

import com.ltu.m7019e.moviebrowz.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieDetailResponse {

    @Json(name = "imdb_id")
    var imdbId: String = ""

    @Json(name = "homepage")
    var homepage: String = ""

    /*@Json(name = "genres")
    var genres: Int = 0*/
}