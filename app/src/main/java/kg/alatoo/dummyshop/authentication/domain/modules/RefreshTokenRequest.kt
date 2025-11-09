package kg.alatoo.dummyshop.authentication.domain.modules

data class RefreshTokenRequest(
    val refreshToken : String = "",
    val expiresInMins : Int = 60
)
