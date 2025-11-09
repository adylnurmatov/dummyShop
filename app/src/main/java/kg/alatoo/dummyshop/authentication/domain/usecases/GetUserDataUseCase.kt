package kg.alatoo.dummyshop.authentication.domain.usecases

import kg.alatoo.dummyshop.authentication.domain.AuthRepository
import kg.alatoo.dummyshop.authentication.domain.modules.LoginResponse
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(accessToken : String) : LoginResponse{
        return repository.getUserData(accessToken)
    }

}