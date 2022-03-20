package com.example.cryptotracker
// my api key =905b5f07-2cc2-49b3-8f8d-68bfc2f6efbb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val TAG = "MainActivity"
const val BASE_URL = "https://pro-api.coinmarketcap.com/v1/"
const val API_KEY="905b5f07-2cc2-49b3-8f8d-68bfc2f6efbb"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        val trackerService =retrofit.create(TrackerService::class.java)
        trackerService.SearchCrypto("${API_KEY}").enqueue(object :Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Log.i(TAG,"responose is $response")
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i(TAG,"failure is ${t}")
            }

        })




    }
}
