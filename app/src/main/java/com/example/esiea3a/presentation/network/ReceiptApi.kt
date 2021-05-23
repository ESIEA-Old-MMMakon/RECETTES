package com.example.esiea3a.presentation.network

import com.example.esiea3a.presentation.data.Receipt
import retrofit2.Call
import retrofit2.http.GET
interface ReceiptApi {
    @GET("receipt")
    fun fetchAllReceipts(): Call<ReceiptResponse>

}