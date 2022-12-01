package com.schimidt.exerciseRoutine.application

import android.app.Application
import com.schimidt.exerciseRoutine.di.appModule
import com.schimidt.exerciseRoutine.di.dataModule
import com.schimidt.exerciseRoutine.di.networkModule
import com.schimidt.exerciseRoutine.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, networkModule, viewModelModule, dataModule)
        }
    }
}