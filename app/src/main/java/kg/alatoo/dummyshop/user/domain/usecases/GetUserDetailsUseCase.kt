package kg.alatoo.dummyshop.user.domain.usecases

import kg.alatoo.dummyshop.user.domain.UserDetailsRepository
import kg.alatoo.dummyshop.user.domain.modules.UserDetails
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
  private val repository: UserDetailsRepository
) {

    suspend operator fun invoke(refreshToken : String) : UserDetails{
        return repository.getUserDetails(refreshToken)
    }

}