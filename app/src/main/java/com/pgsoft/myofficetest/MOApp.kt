package com.pgsoft.myofficetest

import android.app.Application
import com.pgsoft.myofficetest.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MOApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //fileProperties()
            androidLogger(Level.DEBUG)
            androidContext(this@MOApp)
            modules(koinModules)
        }
    }


}