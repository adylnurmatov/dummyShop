package kg.alatoo.dummyshop.user.domain

import kg.alatoo.dummyshop.user.domain.modules.UserDetails

interface UserDetailsRepository {

    suspend fun getUserDetails(refreshToken : String) : UserDetails

    suspend fun getUserAccessToken() : String

    suspend fun saveAccessToken(accessToken: String)

}