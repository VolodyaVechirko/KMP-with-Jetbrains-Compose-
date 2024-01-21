package com.vechirko.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        fun appContext(): Context = context
            ?: throw IllegalStateException("Application context is null")
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}