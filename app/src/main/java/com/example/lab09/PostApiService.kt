// ProductApiService.kt
package com.example.lab09

import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}

data class ProductResponse(
    val products: List<ProductModel>
)

data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val thumbnail: String
)
