package com.ltu.m7019e.moviebrowz

import android.app.Application
import timber.log.Timber

class TheMovieDataBase : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}