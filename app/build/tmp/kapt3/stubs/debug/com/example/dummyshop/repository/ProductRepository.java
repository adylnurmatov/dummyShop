package com.example.dummyshop.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/dummyshop/repository/ProductRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "api", "Lcom/example/dummyshop/data/remote/ApiService;", "getCategories", "", "Lcom/example/dummyshop/data/model/Category;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProduct", "Lcom/example/dummyshop/data/model/Product;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listByCategory", "Lcom/example/dummyshop/data/model/ProductsResponse;", "slug", "", "limit", "skip", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listProducts", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchProducts", "query", "app_debug"})
public final class ProductRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.dummyshop.data.remote.ApiService api = null;
    
    public ProductRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listProducts(int limit, int skip, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.ProductsResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int limit, int skip, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.ProductsResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String slug, int limit, int skip, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.ProductsResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProduct(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.Product> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.dummyshop.data.model.Category>> $completion) {
        return null;
    }
}