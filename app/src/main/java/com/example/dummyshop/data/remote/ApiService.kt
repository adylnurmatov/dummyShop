package com.example.dummyshop.data.remote

import com.example.dummyshop.data.model.AddCartRequest
import com.example.dummyshop.data.model.Cart
import com.example.dummyshop.data.model.Category
import com.example.dummyshop.data.model.LoginRequest
import com.example.dummyshop.data.model.LoginResponse
import com.example.dummyshop.data.model.ProductsResponse
import com.example.dummyshop.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/products")
    suspend fun getProducts(@Query("limit") limit: Int = 100, @Query("skip") skip: Int = 0, @Query("select") select: String? = null): ProductsResponse

    @GET("/products/search")
    suspend fun searchProducts(@Query("q") query: String, @Query("limit") limit: Int = 100, @Query("skip") skip: Int = 0): ProductsResponse

    @GET("/products/{id}")
    suspend fun getProduct(@Path("id") id: Int): com.example.dummyshop.data.model.Product

    @GET("/products/categories")
    suspend fun getCategories(): List<Category>

    @GET("/products/category/{slug}")
    suspend fun getProductsByCategory(@Path("slug") slug: String, @Query("limit") limit: Int = 100, @Query("skip") skip: Int = 0): ProductsResponse

    @POST("/carts/add")
    suspend fun addCart(@Body request: AddCartRequest): Cart

    @GET("/carts/{id}")
    suspend fun getCart(@Path("id") cartId: Int): Cart

    @GET("/users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}


