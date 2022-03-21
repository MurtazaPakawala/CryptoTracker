package com.example.cryptotracker
// my api key =905b5f07-2cc2-49b3-8f8d-68bfc2f6efbb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
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


        //recycler view stuff
        //1 step dragging it -done
        //now make the layout
        rvCrypto.layoutManager =LinearLayoutManager(this)
        //getting the data
        val crypto = mutableListOf<Crypto>()
        //making the adapter
        val adapter = CryptoAdapter(this,crypto)
        rvCrypto.adapter =adapter


        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        val trackerService =retrofit.create(TrackerService::class.java)
        trackerService.SearchCrypto("${API_KEY}").enqueue(object :Callback<CryptoResult>{
            override fun onResponse(call: Call<CryptoResult>, response: Response<CryptoResult>) {
                val body = response.body()
                if(body==null)
                {
                    Log.w("TAG","did not get a valid response something is wrong please check again")
                    return
                }

                crypto.addAll(body.cryptos)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<CryptoResult>, t: Throwable) {
                Log.i(TAG,"failure is ${t}")
            }

        })




    }
}
