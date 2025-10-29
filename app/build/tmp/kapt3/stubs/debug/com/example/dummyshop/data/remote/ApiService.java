package com.example.dummyshop.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ.\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\t2\b\b\u0003\u0010\u0015\u001a\u00020\t2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J,\u0010\u0019\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u00172\b\b\u0003\u0010\u0014\u001a\u00020\t2\b\b\u0003\u0010\u0015\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0001\u0010\u0004\u001a\u00020\"H\u00a7@\u00a2\u0006\u0002\u0010#J,\u0010$\u001a\u00020\u00132\b\b\u0001\u0010%\u001a\u00020\u00172\b\b\u0003\u0010\u0014\u001a\u00020\t2\b\b\u0003\u0010\u0015\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/example/dummyshop/data/remote/ApiService;", "", "addCart", "Lcom/example/dummyshop/data/model/Cart;", "request", "Lcom/example/dummyshop/data/model/AddCartRequest;", "(Lcom/example/dummyshop/data/model/AddCartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCart", "cartId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "", "Lcom/example/dummyshop/data/model/Category;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProduct", "Lcom/example/dummyshop/data/model/Product;", "id", "getProducts", "Lcom/example/dummyshop/data/model/ProductsResponse;", "limit", "skip", "select", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductsByCategory", "slug", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lcom/example/dummyshop/data/model/User;", "userId", "login", "Lretrofit2/Response;", "Lcom/example/dummyshop/data/model/LoginResponse;", "Lcom/example/dummyshop/data/model/LoginRequest;", "(Lcom/example/dummyshop/data/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchProducts", "query", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "/auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.dummyshop.data.model.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.dummyshop.data.model.LoginResponse>> $completion);
    
    @retrofit2.http.GET(value = "/products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProducts(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "skip")
    int skip, @retrofit2.http.Query(value = "select")
    @org.jetbrains.annotations.Nullable()
    java.lang.String select, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.ProductsResponse> $completion);
    
    @retrofit2.http.GET(value = "/products/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchProducts(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "skip")
    int skip, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.ProductsResponse> $completion);
    
    @retrofit2.http.GET(value = "/products/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProduct(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.Product> $completion);
    
    @retrofit2.http.GET(value = "/products/categories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.dummyshop.data.model.Category>> $completion);
    
    @retrofit2.http.GET(value = "/products/category/{slug}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductsByCategory(@retrofit2.http.Path(value = "slug")
    @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "skip")
    int skip, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.ProductsResponse> $completion);
    
    @retrofit2.http.POST(value = "/carts/add")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addCart(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.dummyshop.data.model.AddCartRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.Cart> $completion);
    
    @retrofit2.http.GET(value = "/carts/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCart(@retrofit2.http.Path(value = "id")
    int cartId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.Cart> $completion);
    
    @retrofit2.http.GET(value = "/users/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUser(@retrofit2.http.Path(value = "id")
    int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dummyshop.data.model.User> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}