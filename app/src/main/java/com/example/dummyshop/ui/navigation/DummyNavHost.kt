package com.example.dummyshop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dummyshop.ui.screens.CartScreen
import com.example.dummyshop.ui.screens.LoginScreen
import com.example.dummyshop.ui.screens.OrderConfirmationScreen
import com.example.dummyshop.ui.screens.ProductDetailScreen
import com.example.dummyshop.ui.screens.ProductListScreen
import com.example.dummyshop.ui.screens.ProfileScreen
import com.example.dummyshop.viewmodel.AuthViewModel

@Composable
fun DummyNavHost() {
    val navController = rememberNavController()
    val authVm: AuthViewModel = viewModel()
    val token by authVm.tokenFlow.collectAsState(initial = null)

    val startDestination = if (token.isNullOrBlank()) NavRoutes.LOGIN else NavRoutes.PRODUCTS

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavRoutes.LOGIN) {
            LoginScreen(onLoggedIn = { navController.navigate(NavRoutes.PRODUCTS) { popUpTo(NavRoutes.LOGIN) { inclusive = true } } })
        }
        composable(NavRoutes.PRODUCTS) {
            ProductListScreen(
                onOpenProduct = { id -> navController.navigate("product/$id") },
                onOpenProfile = { navController.navigate(NavRoutes.PROFILE) },
                onOpenCart = { cartId -> navController.navigate("cart/$cartId") }
            )
        }
        composable(
            NavRoutes.PRODUCT_DETAIL,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            ProductDetailScreen(
                productId = id,
                onAddedToCart = { navController.navigate(NavRoutes.ORDER_CONFIRMED) }
            )
        }
        composable(
            NavRoutes.CART,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            CartScreen(cartId = id, onPlaceOrder = { navController.navigate(NavRoutes.ORDER_CONFIRMED) })
        }
        composable(NavRoutes.ORDER_CONFIRMED) {
            OrderConfirmationScreen(onContinue = { navController.popBackStack() })
        }
        composable(NavRoutes.PROFILE) {
            ProfileScreen()
        }
    }
}


