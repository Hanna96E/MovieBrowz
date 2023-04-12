package com.ltu.m7019e.moviebrowz.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("posterImageUrl")
fun bindPosterImage(imgView: ImageView, imgUrl: String){
    imgUrl.let { posterPath ->
        Glide
        .with(imgView)
        .load(Constants.POSTER_IMAGE_BASE_URL + Constants.POSTER_IMAGE_WIDTH + posterPath)
        .into(imgView)
    }
}