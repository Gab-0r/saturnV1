package com.example.saturnv1.model

data class Product(
    var id: String ? = null,
    var productName: String,
    var productType: String,
    var productPrice: Int,
    var productDescription: String,
    var urlPhoto: String = ""
)
