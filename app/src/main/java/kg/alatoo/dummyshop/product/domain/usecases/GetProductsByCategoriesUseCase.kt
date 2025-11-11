package kg.alatoo.dummyshop.product.domain.usecases

import kg.alatoo.dummyshop.product.domain.ProductsListRepository
import kg.alatoo.dummyshop.product.domain.modules.ProductsResponse
import javax.inject.Inject

class GetProductsByCategoriesUseCase @Inject constructor(
    private val repository: ProductsListRepository
) {
    suspend operator fun invoke(
        category: String,
        pageNumber: Int = 1,
        limit : Int = 25,
        sortBy: String = "title",
        sortingOrder: String = "asc"
    ): ProductsResponse {

        return repository.getProductsByCategories(
            category = category,
            pageNumber = pageNumber,
            limit = limit ,
            sortBy = sortBy,
            sortingOrder = sortingOrder
        )
    }

}