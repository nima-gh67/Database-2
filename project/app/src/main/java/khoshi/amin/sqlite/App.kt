package khoshi.amin.sqlite

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        const val DATABASE_NAME = "db0"
    }

    override fun onCreate() {
        super.onCreate()
    }
}