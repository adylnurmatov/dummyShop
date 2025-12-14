package kg.alatoo.dummyshop.cart.domain.modules

import kg.alatoo.dummyshop.product.domain.modules.Product

data class Cart(
    val id : Long = 0,
    val products: List<CartsProducts> = emptyList(),
    val total: Float = 0f,
    val discountedTotal: Float = 0f,
    val userId: Long = 0,
    val totalProducts: Int = 0,
    val totalQuantity: Int = 0,
)

data class CartItem(
    val id : Long = 0,
    val products: List<Product> = emptyList(),
    val total: Float = 0f,
    val discountedTotal: Float = 0f,
    val userId: Long = 0,
    val totalProducts: Int = 0,
    val totalQuantity: Int = 0,
)