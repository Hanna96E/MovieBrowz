package com.ltu.m7019e.moviebrowz

import android.app.Application
import timber.log.Timber

class MovieBrowz : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}