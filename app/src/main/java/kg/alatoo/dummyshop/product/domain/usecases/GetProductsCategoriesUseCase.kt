package kg.alatoo.dummyshop.product.domain.usecases

import kg.alatoo.dummyshop.product.domain.ProductsListRepository
import javax.inject.Inject

class GetProductsCategoriesUseCase @Inject constructor(
    private val repository: ProductsListRepository
) {
    suspend operator fun invoke(): List<String> {
        return repository.getProductsCategories()
    }

}