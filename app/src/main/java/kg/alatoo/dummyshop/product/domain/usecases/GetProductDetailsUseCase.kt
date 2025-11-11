package kg.alatoo.dummyshop.product.domain.usecases

import kg.alatoo.dummyshop.product.domain.ProductsListRepository
import kg.alatoo.dummyshop.product.domain.modules.Product
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
   private val repository: ProductsListRepository
) {
    suspend operator fun invoke(productId : Long) : Product{
        return repository.getProductDetails(productId)
    }
}