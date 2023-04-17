package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import com.ltu.m7019e.moviebrowz.utils.Constants.IMDB_BASE_URL
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetail (
        var id: Int,
        var imdbId: String,
        var homepage: String,
        var genres: List<Genre>
        ) : Parcelable
{
        fun genresToString(): String{
                val genreNames = mutableListOf<String>()
                genres.forEach{genre: Genre ->
                        genreNames.add(genre.name)
                }
                return genreNames.joinToString(separator = " | ")
        }

        fun getImdbLink(): String{
                return IMDB_BASE_URL + imdbId
        }
}