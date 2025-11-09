package kg.alatoo.dummyshop.authentication.data

import kg.alatoo.dummyshop.authentication.domain.modules.LoginRequest
import kg.alatoo.dummyshop.authentication.domain.modules.LoginResponse
import kg.alatoo.dummyshop.authentication.domain.modules.RefreshTokenRequest
import kg.alatoo.dummyshop.authentication.domain.modules.RefreshTokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login( @Body loginRequest : LoginRequest) : Response<LoginResponse>

    @POST("auth/refresh")
    suspend fun refreshToken( @Body refreshTokenRequest: RefreshTokenRequest) : Response<RefreshTokenResponse>

    @GET("auth/me")
    suspend fun getUserData( @Header("Authorization") accessToken: String) : Response<LoginResponse>

}
