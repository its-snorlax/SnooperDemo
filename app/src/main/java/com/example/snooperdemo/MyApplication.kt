package com.example.snooperdemo

import android.app.Application
import com.prateekj.snooper.AndroidSnooper

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidSnooper.init(this)
    }
}