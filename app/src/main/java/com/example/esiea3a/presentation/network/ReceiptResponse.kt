package com.example.esiea3a.presentation.network

import com.example.esiea3a.presentation.data.Receipt

data class ReceiptResponse(
    val count: Int,
    val next: String,
    val result: List<Receipt>
)
