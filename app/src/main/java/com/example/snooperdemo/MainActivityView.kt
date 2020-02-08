package com.example.snooperdemo

import android.graphics.Bitmap

interface MainActivityView {
    fun onSuccess()
    fun onRequestProgress()
    fun setImageIntoView(bm: Bitmap)
}