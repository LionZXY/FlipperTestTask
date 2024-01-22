package com.lionzxy.flippertesttask

import android.app.Application
import com.lionzxy.flippertesttask.core.di.ComponentHolder
import com.lionzxy.flippertesttask.di.DaggerAppComponent
import timber.log.Timber

class FlipperApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.factory()
            .create(
                context = this,
                application = this
            )

        ComponentHolder.components += appComponent

        if (BuildConfig.INTERNAL) {
            Timber.plant(Timber.DebugTree())
        }
    }
}