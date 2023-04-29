package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class MovieReview (

    @Json(name = "id")
    var id: String = "",

    @Json(name = "author")
    var author: String,

    @Json(name = "content")
    var content: String,

    @Json(name = "created_at")
    var createdAt: String

    ) : Parcelable
{
    fun getDate(dateString: String): String{
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val outputFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US)

        // Parse the input string into a Date object
        val date = inputFormat.parse(dateString)

        // Format the Date object back into a string
        return outputFormat.format(date)

    }
}