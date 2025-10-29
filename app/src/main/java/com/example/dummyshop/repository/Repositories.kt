package com.example.dummyshop.repository

import android.content.Context
import com.example.dummyshop.data.local.TokenManager
import com.example.dummyshop.data.model.AddCartProduct
import com.example.dummyshop.data.model.AddCartRequest
import com.example.dummyshop.data.model.Cart
import com.example.dummyshop.data.model.Category
import com.example.dummyshop.data.model.LoginRequest
import com.example.dummyshop.data.model.LoginResponse
import com.example.dummyshop.data.model.Product
import com.example.dummyshop.data.model.ProductsResponse
import com.example.dummyshop.data.model.User
import com.example.dummyshop.data.remote.ApiService
import com.example.dummyshop.data.remote.NetworkModule

class AuthRepository(context: Context) {
    private val api: ApiService = NetworkModule.provideApiService(context)
    private val tokenManager = TokenManager(context)

    suspend fun login(username: String, password: String): LoginResponse {
        val response = api.login(LoginRequest(username, password))
        if (response.isSuccessful) {
            val body = response.body() ?: throw Exception("Empty response body")
            tokenManager.saveToken(body.token)
            tokenManager.saveUserId(body.id)
            return body
        } else {
            val msg = response.errorBody()?.string()
            throw Exception(msg ?: "Login failed: HTTP ${response.code()}")
        }
    }

    val tokenFlow = tokenManager.tokenFlow
    val userIdFlow = tokenManager.userIdFlow
    suspend fun logout() {
        tokenManager.saveToken(null)
        tokenManager.saveUserId(null)
    }
}

class ProductRepository(context: Context) {
    private val api: ApiService = NetworkModule.provideApiService(context)
    suspend fun listProducts(limit: Int = 100, skip: Int = 0): ProductsResponse = api.getProducts(limit = limit, skip = skip)
    suspend fun searchProducts(query: String, limit: Int = 100, skip: Int = 0): ProductsResponse = api.searchProducts(query = query, limit = limit, skip = skip)
    suspend fun listByCategory(slug: String, limit: Int = 100, skip: Int = 0): ProductsResponse = api.getProductsByCategory(slug = slug, limit = limit, skip = skip)
    suspend fun getProduct(id: Int): Product = api.getProduct(id)
    suspend fun getCategories(): List<Category> = api.getCategories()
}

class CartRepository(context: Context) {
    private val api: ApiService = NetworkModule.provideApiService(context)
    suspend fun addToCart(userId: Int, productId: Int, quantity: Int): Cart {
        val req = AddCartRequest(userId = userId, products = listOf(AddCartProduct(productId, quantity)))
        return api.addCart(req)
    }
    suspend fun getCart(cartId: Int): Cart = api.getCart(cartId)
}

class UserRepository(context: Context) {
    private val api: ApiService = NetworkModule.provideApiService(context)
    suspend fun getUser(userId: Int): User = api.getUser(userId)
}


