package kg.alatoo.dummyshop.authentication.domain.usecases

import kg.alatoo.dummyshop.authentication.domain.AuthRepository
import javax.inject.Inject

class GetSavedRefreshTokenUseCase @Inject constructor (
    private val repository: AuthRepository
) {
    suspend operator fun invoke() : String?{
        return repository.getSavedRefreshToken()
    }

}