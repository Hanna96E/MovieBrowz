package com.ltu.m7019e.moviebrowz.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ltu.m7019e.moviebrowz.database.Movies
import com.ltu.m7019e.moviebrowz.model.Movie

class MovieListViewModel(application: Application): AndroidViewModel(application) {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() {
            return _movieList
        }

    init {
        _movieList.postValue(Movies().list)
    }
}