package kg.alatoo.dummyshop.authentication.domain.usecases

import kg.alatoo.dummyshop.authentication.domain.AuthRepository
import kg.alatoo.dummyshop.authentication.domain.modules.LoginRequest
import kg.alatoo.dummyshop.authentication.domain.modules.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor (
    private val repository: AuthRepository
) {
    suspend operator fun invoke(loginRequest: LoginRequest) : LoginResponse{
        return repository.login(loginRequest)
    }
}