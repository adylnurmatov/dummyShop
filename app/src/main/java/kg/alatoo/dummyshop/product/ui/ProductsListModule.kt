package kg.alatoo.dummyshop.product.ui

import kg.alatoo.dummyshop.product.data.ProductsApi
import kg.alatoo.dummyshop.product.data.ProductsListRepositoryImp
import kg.alatoo.dummyshop.product.domain.ProductsListRepository
import kg.alatoo.dummyshop.product.domain.usecases.GetAllProductsUseCase
import kg.alatoo.dummyshop.product.domain.usecases.GetProductDetailsUseCase
import kg.alatoo.dummyshop.product.domain.usecases.GetProductsByCategoriesUseCase
import kg.alatoo.dummyshop.product.domain.usecases.GetProductsCategoriesUseCase
import kg.alatoo.dummyshop.product.domain.usecases.GetSearchedProductsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsListRepositoryBinder {
    @Binds
    abstract fun bindRepositoryWithImp(
        productsListRepositoryImp: ProductsListRepositoryImp
    ): ProductsListRepository
}

@Module
@InstallIn(SingletonComponent::class)
object ProductsListModule {

    @Provides
    @Singleton
    fun provideProductsApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetAllProductsUseCase(
        repository: ProductsListRepository
    ): GetAllProductsUseCase {
        return GetAllProductsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetProductsByCategoriesUseCase(
        repository: ProductsListRepository
    ): GetProductsByCategoriesUseCase {
        return GetProductsByCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetProductsCategoriesUseCase(
        repository: ProductsListRepository
    ): GetProductsCategoriesUseCase {
        return GetProductsCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetSearchedProductsUseCase(
        repository: ProductsListRepository
    ): GetSearchedProductsUseCase {
        return GetSearchedProductsUseCase(repository)
    }

    fun provideGetProductDetailsUseCase(
        repository: ProductsListRepository
    ) : GetProductDetailsUseCase{
        return GetProductDetailsUseCase(repository)
    }


}