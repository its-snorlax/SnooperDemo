package com.example.snooperdemo

import com.prateekj.snooper.okhttp.SnooperInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {

    private var okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

    fun <T> build(clazz: Class<T>?): T {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://avatars.dicebear.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())

        val client = okHttpClientBuilder.addInterceptor(SnooperInterceptor()).build()
        return retrofitBuilder.client(client).build().create(clazz)
    }
}