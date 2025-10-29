package com.example.dummyshop.data.model

import com.squareup.moshi.Json

data class LoginRequest(
    val username: String,
    val password: String,
    val expiresInMins: Int = 60
)

data class LoginResponse(
    val id: Int,
    val username: String,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val gender: String?,
    val image: String?,
    val token: String
)

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double?,
    val rating: Double?,
    val stock: Int?,
    val brand: String?,
    val category: String?,
    val thumbnail: String?,
    val images: List<String> = emptyList()
)

data class ProductsResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

// According to DummyJSON, /products/categories returns objects: { slug, name, url }
data class Category(
    val slug: String,
    val name: String,
    val url: String
)

data class CartItem(
    val id: Int,
    @Json(name = "title") val title: String? = null,
    val price: Double,
    val quantity: Int,
    val total: Double? = null,
    val discountPercentage: Double? = null,
    val discountedTotal: Double? = null,
    val thumbnail: String? = null
)

data class Cart(
    val id: Int?,
    val products: List<CartItem>,
    val total: Double?,
    val discountedTotal: Double?,
    val userId: Int?,
    val totalProducts: Int?,
    val totalQuantity: Int?
)

data class AddCartRequest(
    val userId: Int,
    val products: List<AddCartProduct>
)

data class AddCartProduct(
    val id: Int,
    val quantity: Int
)

data class User(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val username: String?,
    val email: String?,
    val image: String?
)


