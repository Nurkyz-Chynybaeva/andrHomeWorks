package com.example.andrhomeworks

import android.app.Application
import androidx.room.Room
import com.example.andrhomeworks.database.AppDatabase

class App: Application() {

    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "data")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        private var mInstance: App? = null
        val instance get() = mInstance!!
    }
}

val Any.Injector: App
    get() = App.instance