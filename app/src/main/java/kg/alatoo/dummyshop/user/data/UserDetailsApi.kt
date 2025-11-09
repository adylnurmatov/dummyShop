package kg.alatoo.dummyshop.user.data

import kg.alatoo.dummyshop.user.domain.modules.UserDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface UserDetailsApi {

    @GET("auth/me")
    suspend fun getUserData( @Header("Authorization") accessToken: String) : Response<UserDetails>

}