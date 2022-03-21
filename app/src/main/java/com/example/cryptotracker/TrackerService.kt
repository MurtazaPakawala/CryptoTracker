package com.example.cryptotracker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TrackerService {

    @GET("cryptocurrency/listings/latest")
    fun SearchCrypto(
        @Header("X-CMC_PRO_API_KEY") authHeader :String
    ) : Call<CryptoResult>
}