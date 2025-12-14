package kg.alatoo.dummyshop.cart.domain.modules

data class CartsProducts(
    val id: Long,
    val title: String,
    val price: Float,
    val quantity: Int,
    val total: Float,
    val discountPercentage: Float,
    val discountedTotal: Float,
    val thumbnail: String
)