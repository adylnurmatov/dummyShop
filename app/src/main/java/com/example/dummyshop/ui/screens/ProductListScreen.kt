package com.example.dummyshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.dummyshop.data.model.Product
import com.example.dummyshop.viewmodel.ProductListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(onOpenProduct: (Int) -> Unit, onOpenProfile: () -> Unit, onOpenCart: (Int) -> Unit) {
    val vm: ProductListViewModel = viewModel()
    val productsState = vm.products.value
    val categoriesState = vm.categories.value
    var query by remember { mutableStateOf("") }
    var categoryMenu by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        vm.load()
        vm.loadCategories()
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Products") }, actions = {
            IconButton(onClick = onOpenProfile) { Text("P") }
        })
    }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = query, onValueChange = {
                    query = it
                    vm.updateQuery(it)
                }, modifier = Modifier.weight(1f), label = { Text("Search") })
                Column {
                    Text("Category")
                    Text("▼", modifier = Modifier.clickable { categoryMenu = true })
                    DropdownMenu(expanded = categoryMenu, onDismissRequest = { categoryMenu = false }) {
                        categoriesState.data?.forEach { cat ->
                            DropdownMenuItem(text = { Text(cat.name) }, onClick = {
                                categoryMenu = false
                                vm.selectCategory(cat.slug)
                            })
                        }
                    }
                }
            }

            when {
                productsState.loading -> {
                    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                    }
                }
                productsState.error != null -> Text(productsState.error ?: "Error")
                else -> {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(productsState.data ?: emptyList()) { product ->
                            ProductRow(product) { onOpenProduct(product.id) }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProductRow(product: Product, onClick: () -> Unit) {
    Row(Modifier.fillMaxWidth().clickable { onClick() }.padding(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        AsyncImage(model = product.thumbnail, contentDescription = product.title)
        Column(Modifier.weight(1f)) {
            Text(product.title)
            Text("$${product.price}")
        }
    }
}


