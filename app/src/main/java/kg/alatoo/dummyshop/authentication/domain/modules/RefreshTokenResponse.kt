package kg.alatoo.dummyshop.authentication.domain.modules

data class RefreshTokenResponse(
    val accessToken : String = "",
    val refreshToken : String = ""
)
