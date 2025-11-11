package kg.alatoo.dummyshop.product.domain.modules

data class Dimensions(
    val width: Float = 0f,
    val height: Float = 0f,
    val depth: Float = 0f
){

    fun getProductDimensions() : String{

        return  "${this.depth} * ${this.height} * ${this.depth}"
    }

}
