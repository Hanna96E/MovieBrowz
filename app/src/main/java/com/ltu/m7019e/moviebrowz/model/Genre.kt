package com.ltu.m7019e.moviebrowz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre (
        var id: Int,
        var name: String
        ): Parcelable
{
        override fun toString(): String = name
}