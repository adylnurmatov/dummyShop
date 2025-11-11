package kg.alatoo.dummyshop.product.domain

import kg.alatoo.dummyshop.product.domain.modules.Product
import kg.alatoo.dummyshop.product.domain.modules.ProductsResponse

interface ProductsListRepository {

    suspend fun getAllProducts(
        pageNumber: Int = 1,
        sortBy: String = "title",
        sortingOrder: String = "asc"
    ): ProductsResponse

    suspend fun getSearchedProducts(
        searchQuery: String,
        pageNumber: Int = 1,
        sortBy: String = "title",
        sortingOrder: String = "asc"
    ): ProductsResponse

    suspend fun getProductsCategories(): List<String>

    suspend fun getProductsByCategories(
        category: String,
        pageNumber: Int = 1,
        limit : Int = 25,
        sortBy: String = "title",
        sortingOrder: String = "asc"
    ): ProductsResponse

    suspend fun getProductDetails(
        productId: Long
    ) : Product


}
