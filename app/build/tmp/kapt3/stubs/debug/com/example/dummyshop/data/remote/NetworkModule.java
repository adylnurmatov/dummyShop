package com.example.dummyshop.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/dummyshop/data/remote/NetworkModule;", "", "()V", "BASE_URL", "", "provideApiService", "Lcom/example/dummyshop/data/remote/ApiService;", "context", "Landroid/content/Context;", "app_debug"})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://dummyjson.com/";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.dummyshop.data.remote.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.dummyshop.data.remote.ApiService provideApiService(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}