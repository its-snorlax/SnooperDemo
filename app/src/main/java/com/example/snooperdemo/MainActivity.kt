package com.example.snooperdemo

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.snooperdemo.R.id.image_view
import com.example.snooperdemo.R.id.progress_bar
import com.example.snooperdemo.ServiceBuilder.build
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageView

    private lateinit var progressBar: ProgressBar

    private lateinit var apiService: APIService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(image_view)
        progressBar = findViewById(progress_bar)

        makeApiCall()
    }

    private fun makeApiCall() {
        apiService = build(APIService::class.java)
        progressBar.visibility = View.VISIBLE

        apiService.getSvg().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    progressBar.visibility = View.GONE
                    val body = response.body()
                    val inputStream = body?.byteStream()
                    image.setImageBitmap(BitmapFactory.decodeStream(inputStream))
                }
            }
        })
    }

}
