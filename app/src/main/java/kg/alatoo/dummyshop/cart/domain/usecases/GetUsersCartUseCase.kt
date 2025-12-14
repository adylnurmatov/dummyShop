package kg.alatoo.dummyshop.cart.domain.usecases

import kg.alatoo.dummyshop.cart.domain.CartsRepository
import kg.alatoo.dummyshop.cart.domain.modules.Cart
import javax.inject.Inject

class GetUsersCartUseCase @Inject constructor(
    private val repository: CartsRepository
) {

    suspend operator fun invoke(): Cart {
        return repository.getUsersCart()
    }

}