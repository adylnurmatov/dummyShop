package com.example.dummyshop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyshop.data.model.Cart
import com.example.dummyshop.data.model.Product
import com.example.dummyshop.data.model.User
import com.example.dummyshop.repository.AuthRepository
import com.example.dummyshop.repository.CartRepository
import com.example.dummyshop.repository.ProductRepository
import com.example.dummyshop.repository.UserRepository
import com.example.dummyshop.data.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UiState<T>(
    val loading: Boolean = false,
    val data: T? = null,
    val error: String? = null
)

class AuthViewModel(app: Application) : AndroidViewModel(app) {
    private val authRepo = AuthRepository(app)
    private val _loginState = MutableStateFlow(UiState<Unit>())
    val loginState: StateFlow<UiState<Unit>> = _loginState.asStateFlow()
    val tokenFlow = authRepo.tokenFlow
    val userIdFlow = authRepo.userIdFlow

    fun login(username: String, password: String) {
        _loginState.value = UiState(loading = true)
        viewModelScope.launch {
            try {
                authRepo.login(username, password)
                _loginState.value = UiState(data = Unit)
            } catch (e: Exception) {
                _loginState.value = UiState(error = e.message ?: "Login failed")
            }
        }
    }

    fun logout() {
        viewModelScope.launch { authRepo.logout() }
    }
}

class ProductListViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = ProductRepository(app)
    private val _products = MutableStateFlow(UiState<List<Product>>(loading = true))
    val products: StateFlow<UiState<List<Product>>> = _products.asStateFlow()
    private val _categories = MutableStateFlow(UiState<List<Category>>())
    val categories: StateFlow<UiState<List<Category>>> = _categories.asStateFlow()

    private var currentQuery: String? = null
    private var currentCategorySlug: String? = null

    fun load() {
        _products.update { it.copy(loading = true, error = null) }
        viewModelScope.launch {
            try {
                val resp = when {
                    !currentQuery.isNullOrBlank() -> repo.searchProducts(currentQuery!!)
                    !currentCategorySlug.isNullOrBlank() -> repo.listByCategory(currentCategorySlug!!)
                    else -> repo.listProducts()
                }
                _products.value = UiState(data = resp.products)
            } catch (e: Exception) {
                _products.value = UiState(error = e.message)
            }
        }
    }

    fun updateQuery(query: String) {
        currentQuery = query
        currentCategorySlug = null
        load()
    }

    fun selectCategory(slug: String) {
        currentCategorySlug = slug
        currentQuery = null
        load()
    }

    fun loadCategories() {
        _categories.update { it.copy(loading = true, error = null) }
        viewModelScope.launch {
            try {
                val resp = repo.getCategories()
                _categories.value = UiState(data = resp)
            } catch (e: Exception) {
                _categories.value = UiState(error = e.message)
            }
        }
    }
}

class ProductDetailViewModel(app: Application) : AndroidViewModel(app) {
    private val productRepo = ProductRepository(app)
    private val cartRepo = CartRepository(app)
    private val authRepo = AuthRepository(app)

    private val _product = MutableStateFlow(UiState<Product>(loading = true))
    val product: StateFlow<UiState<Product>> = _product.asStateFlow()
    private val _addCartState = MutableStateFlow(UiState<Cart>())
    val addCartState: StateFlow<UiState<Cart>> = _addCartState.asStateFlow()

    fun load(id: Int) {
        _product.value = UiState(loading = true)
        viewModelScope.launch {
            try {
                val p = productRepo.getProduct(id)
                _product.value = UiState(data = p)
            } catch (e: Exception) {
                _product.value = UiState(error = e.message)
            }
        }
    }

    fun addToCart(productId: Int, quantity: Int = 1) {
        _addCartState.value = UiState(loading = true)
        viewModelScope.launch {
            try {
                val userId = authRepo.userIdFlow
                var uid: Int? = null
                userId.collect { id ->
                    uid = id
                    return@collect
                }
                val cart = cartRepo.addToCart(uid ?: 1, productId, quantity)
                _addCartState.value = UiState(data = cart)
            } catch (e: Exception) {
                _addCartState.value = UiState(error = e.message)
            }
        }
    }
}

class CartViewModel(app: Application) : AndroidViewModel(app) {
    private val cartRepo = CartRepository(app)
    private val _cart = MutableStateFlow(UiState<Cart>())
    val cart: StateFlow<UiState<Cart>> = _cart.asStateFlow()

    fun load(cartId: Int) {
        _cart.value = UiState(loading = true)
        viewModelScope.launch {
            try {
                val c = cartRepo.getCart(cartId)
                _cart.value = UiState(data = c)
            } catch (e: Exception) {
                _cart.value = UiState(error = e.message)
            }
        }
    }
}

class ProfileViewModel(app: Application) : AndroidViewModel(app) {
    private val userRepo = UserRepository(app)
    private val _user = MutableStateFlow(UiState<User>())
    val user: StateFlow<UiState<User>> = _user.asStateFlow()

    fun load(userId: Int) {
        _user.value = UiState(loading = true)
        viewModelScope.launch {
            try {
                val u = userRepo.getUser(userId)
                _user.value = UiState(data = u)
            } catch (e: Exception) {
                _user.value = UiState(error = e.message)
            }
        }
    }
}


