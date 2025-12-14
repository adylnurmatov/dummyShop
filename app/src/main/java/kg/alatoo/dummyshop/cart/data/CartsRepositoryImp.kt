package kg.alatoo.dummyshop.cart.data

import android.content.SharedPreferences
import kg.alatoo.dummyshop.cart.domain.CartsRepository
import kg.alatoo.dummyshop.cart.domain.modules.Cart
import javax.inject.Inject

class CartsRepositoryImp @Inject constructor(
    private val cartsApi: CartsApi,
    private val sharedPref: SharedPreferences
) : CartsRepository {

    override suspend fun getUsersCart(): Cart {
        var userAccessToken : String? = "5"
        try {
             //userAccessToken = sharedPref.getString(SharedPrefKeys.ACCESS_TOKEN, null)
        }catch (e: Exception){
            userAccessToken = "5"
        }

        val response = cartsApi.getUsersCarts(userAccessToken!!.toLong())
        if (response.isSuccessful) {
            val body = response.body()
            return body ?: throw Exception("Response body is null")
        } else {
            throw Exception("API call failed for userId: $userAccessToken. Code: ${response.code()}, Message: ${response.message()}")
        }
    }
}