package com.example.dummyshop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dummyshop.viewmodel.CartViewModel

@Composable
fun CartScreen(cartId: Int, onPlaceOrder: () -> Unit) {
    val vm: CartViewModel = viewModel()
    val state = vm.cart.value

    LaunchedEffect(cartId) { vm.load(cartId) }

    when {
        state.loading -> Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) { CircularProgressIndicator() }
        state.error != null -> Text(state.error ?: "Error", modifier = Modifier.padding(16.dp))
        else -> {
            val c = state.data
            Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Cart #${c?.id ?: "-"}")
                Text("Items: ${c?.totalProducts ?: 0}")
                Text("Total: $${c?.total ?: 0}")
                Button(onClick = onPlaceOrder) { Text("Place Order") }
            }
        }
    }
}

@Composable
fun OrderConfirmationScreen(onContinue: () -> Unit) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Order placed successfully!")
        Button(onClick = onContinue, modifier = Modifier.padding(top = 16.dp)) { Text("Continue") }
    }
}


