package com.example.dummyshop.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001aR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/dummyshop/viewmodel/ProductDetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_addCartState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/dummyshop/viewmodel/UiState;", "Lcom/example/dummyshop/data/model/Cart;", "_product", "Lcom/example/dummyshop/data/model/Product;", "addCartState", "Lkotlinx/coroutines/flow/StateFlow;", "getAddCartState", "()Lkotlinx/coroutines/flow/StateFlow;", "authRepo", "Lcom/example/dummyshop/repository/AuthRepository;", "cartRepo", "Lcom/example/dummyshop/repository/CartRepository;", "product", "getProduct", "productRepo", "Lcom/example/dummyshop/repository/ProductRepository;", "addToCart", "", "productId", "", "quantity", "load", "id", "app_debug"})
public final class ProductDetailViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.dummyshop.repository.ProductRepository productRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.dummyshop.repository.CartRepository cartRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.dummyshop.repository.AuthRepository authRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.dummyshop.viewmodel.UiState<com.example.dummyshop.data.model.Product>> _product = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.dummyshop.viewmodel.UiState<com.example.dummyshop.data.model.Product>> product = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.dummyshop.viewmodel.UiState<com.example.dummyshop.data.model.Cart>> _addCartState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.dummyshop.viewmodel.UiState<com.example.dummyshop.data.model.Cart>> addCartState = null;
    
    public ProductDetailViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.dummyshop.viewmodel.UiState<com.example.dummyshop.data.model.Product>> getProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.dummyshop.viewmodel.UiState<com.example.dummyshop.data.model.Cart>> getAddCartState() {
        return null;
    }
    
    public final void load(int id) {
    }
    
    public final void addToCart(int productId, int quantity) {
    }
}