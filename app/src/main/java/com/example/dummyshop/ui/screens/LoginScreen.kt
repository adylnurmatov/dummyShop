package com.example.dummyshop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dummyshop.viewmodel.AuthViewModel

@Composable
fun LoginScreen(onLoggedIn: () -> Unit) {
    val vm: AuthViewModel = viewModel()
    val state = vm.loginState
    val current = state.value

    var username by remember { mutableStateOf("kminchelle") }
    var password by remember { mutableStateOf("0lelplR") }

    LaunchedEffect(current.data) {
        if (current.data != null) onLoggedIn()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to DummyShop")
        OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text("Username") }, modifier = Modifier.padding(top = 16.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.padding(top = 8.dp))
        Button(onClick = { vm.login(username, password) }, modifier = Modifier.padding(top = 16.dp), contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)) {
            Text("Login")
        }
        if (current.loading) {
            CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
        }
        current.error?.let { Text(it, modifier = Modifier.padding(top = 8.dp)) }
    }
}


