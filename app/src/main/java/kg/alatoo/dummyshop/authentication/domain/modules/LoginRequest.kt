package kg.alatoo.dummyshop.authentication.domain.modules

data class LoginRequest(
    val username : String = "",
    val password : String = "",
    val expiresInMins : Int = 60
)
