package kg.alatoo.dummyshop.cart.domain

import kg.alatoo.dummyshop.cart.domain.modules.Cart

interface CartsRepository {

    suspend fun getUsersCart() : Cart


}