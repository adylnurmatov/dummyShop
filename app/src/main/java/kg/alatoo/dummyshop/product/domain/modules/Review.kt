package kg.alatoo.dummyshop.product.domain.modules

data class Review(
    val rating: Int = 0,
    val comment: String = "",
    val date: String = "",
    val reviewerName: String = "",
    val reviewerEmail: String = ""
)
