package kg.alatoo.dummyshop.user.domain.modules

data class UserDetails(
    val id : Long = 0,
    val username: String = "",
    val email : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val gender : String = "",
    val image : String = "",
    val accessToken : String = "",
    val refreshToken : String = ""
)
