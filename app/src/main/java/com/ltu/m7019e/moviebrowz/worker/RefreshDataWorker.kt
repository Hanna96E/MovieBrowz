package com.ltu.m7019e.moviebrowz.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class RefreshDataWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {



    override fun doWork(): Result {
        val appContext = applicationContext

        return try {
            movieListViewModel.refreshDataFromRepository()
            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }

    }
}