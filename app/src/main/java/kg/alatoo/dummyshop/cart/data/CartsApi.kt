package kg.alatoo.dummyshop.cart.data

import kg.alatoo.dummyshop.cart.domain.modules.Cart
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CartsApi {

    @GET("carts/{userId}")
    suspend fun getUsersCarts(@Path("userId") userId: Long): Response<Cart>
}