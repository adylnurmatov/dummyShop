package kg.alatoo.dummyshop.user.domain.usecases

import kg.alatoo.dummyshop.user.domain.UserDetailsRepository
import javax.inject.Inject

class GetUserAccessTokenUseCase @Inject constructor(
    private val repository: UserDetailsRepository
) {
    suspend operator fun invoke() : String{
        return repository.getUserAccessToken()
    }

}