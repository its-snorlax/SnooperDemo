package com.example.snooperdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {
    fun <T> build(clazz: Class<T>?): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://avatars.dicebear.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(clazz)
    }
}