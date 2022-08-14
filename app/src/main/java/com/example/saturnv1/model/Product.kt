package com.example.saturnv1.model

data class Product(
    val id: String = "",
    val productName: String,
    val productType: String,
    val productPrice: Int,
    val productDescription: String,
    val urlPhoto: String = ""
)
