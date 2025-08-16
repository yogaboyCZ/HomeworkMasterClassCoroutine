package cz.yogaboy.homeworkmasterclasscoroutine

import android.app.Application
import cz.yogaboy.homeworkmasterclasscoroutine.di.appModule
import cz.yogaboy.homeworkmasterclasscoroutine.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                dataModule
            )
        }
    }
}
