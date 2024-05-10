package com.simtop.simdiary

import android.app.Application
import com.simtop.simdiary.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class SimDiaryApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@SimDiaryApplication)
            modules(appModule)
        }
    }
}