package kg.alatoo.dummyshop.authentication.domain

import kg.alatoo.dummyshop.authentication.domain.modules.LoginRequest
import kg.alatoo.dummyshop.authentication.domain.modules.LoginResponse
import kg.alatoo.dummyshop.authentication.domain.modules.RefreshTokenRequest
import kg.alatoo.dummyshop.authentication.domain.modules.RefreshTokenResponse

interface AuthRepository {

    suspend fun login(  loginRequest : LoginRequest) : LoginResponse

    suspend fun refreshToken( refreshTokenRequest: RefreshTokenRequest) : RefreshTokenResponse

    suspend fun getUserData( accessToken: String) : LoginResponse

    suspend fun getSavedRefreshToken() : String?

}