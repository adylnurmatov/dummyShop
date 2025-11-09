package kg.alatoo.dummyshop.authentication.domain.usecases

import kg.alatoo.dummyshop.authentication.domain.AuthRepository
import kg.alatoo.dummyshop.authentication.domain.modules.RefreshTokenRequest
import kg.alatoo.dummyshop.authentication.domain.modules.RefreshTokenResponse
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(refreshTokenRequest: RefreshTokenRequest) : RefreshTokenResponse{
        return repository.refreshToken(refreshTokenRequest)
    }

}