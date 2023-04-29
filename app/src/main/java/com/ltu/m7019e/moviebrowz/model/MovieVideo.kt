package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import com.ltu.m7019e.moviebrowz.utils.Constants
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieVideo (

    @Json(name = "id")
    var id: String = "",

    @Json(name = "key")
    var key: String,

    @Json(name = "site")
    var site: String

        ) : Parcelable

{
    fun getVideoLink(site:String, key: String): String{
        var baseUrl = ""
        if (site == "YouTube"){
            baseUrl = Constants.YOUTUBE_VIDEO_BASE_URL
        } else if(site == "Vimeo"){
            baseUrl = Constants.VIMEO_VIDEO_BASE_URL
        }
        return baseUrl+key
    }
}