package kg.alatoo.dummyshop.product.domain.usecases

import kg.alatoo.dummyshop.product.domain.ProductsListRepository
import kg.alatoo.dummyshop.product.domain.modules.ProductsResponse
import javax.inject.Inject

class GetSearchedProductsUseCase @Inject constructor(
    private val repository: ProductsListRepository
) {

    suspend operator fun invoke(
        searchQuery: String,
        pageNumber: Int = 1,
        sortBy: String = "title",
        sortingOrder: String = "asc"
    ): ProductsResponse {
        
        return repository.getSearchedProducts(
            searchQuery = searchQuery,
            pageNumber = pageNumber,
            sortBy = sortBy,
            sortingOrder = sortingOrder
        )
    }

}