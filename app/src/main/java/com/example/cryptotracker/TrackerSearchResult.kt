package com.example.cryptotracker

import com.google.gson.annotations.SerializedName

data class CryptoResult(
    @SerializedName("data") val cryptos : List<Crypto>
)

data class Crypto (

    val name : String,
    val symbol : String,
    @SerializedName("quote") val price : cryptoUSD

    )

data class cryptoUSD (
   val USD : GetUSD
        )

data class GetUSD (
    val price : Double
        )
