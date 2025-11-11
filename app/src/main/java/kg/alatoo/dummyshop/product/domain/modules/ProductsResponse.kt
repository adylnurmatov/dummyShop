package kg.alatoo.dummyshop.product.domain.modules

data class ProductsResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
