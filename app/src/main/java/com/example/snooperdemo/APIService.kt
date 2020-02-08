package com.example.snooperdemo

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.Call;

interface APIService {
    @GET("/v2/female/anna.svg")
    fun getSvg(): Call<ResponseBody>
}