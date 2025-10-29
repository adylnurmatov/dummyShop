package com.example.dummyshop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import coil.compose.AsyncImage
import com.example.dummyshop.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(productId: Int, onAddedToCart: () -> Unit) {
    val vm: ProductDetailViewModel = viewModel()
    val state = vm.product.value
    val addState = vm.addCartState.value

    LaunchedEffect(productId) { vm.load(productId) }
    LaunchedEffect(addState.data) { if (addState.data != null) onAddedToCart() }

    when {
        state.loading -> Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) { CircularProgressIndicator() }
        state.error != null -> Text(state.error ?: "Error", modifier = Modifier.padding(16.dp))
        else -> {
            val p = state.data!!
            Column(Modifier.fillMaxSize().padding(16.dp)) {
                AsyncImage(model = p.thumbnail, contentDescription = p.title)
                Spacer(Modifier.height(12.dp))
                Text(p.title)
                Text(p.description)
                Spacer(Modifier.height(12.dp))
                Button(onClick = { vm.addToCart(p.id, 1) }) { Text("Add to Cart") }
                if (addState.loading) { CircularProgressIndicator(modifier = Modifier.padding(12.dp)) }
                addState.error?.let { Text(it, modifier = Modifier.padding(8.dp)) }
            }
        }
    }
}


