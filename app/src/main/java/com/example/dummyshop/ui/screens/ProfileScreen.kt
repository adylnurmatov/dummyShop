package com.example.dummyshop.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dummyshop.viewmodel.AuthViewModel
import com.example.dummyshop.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen() {
    val authVm: AuthViewModel = viewModel()
    val profileVm: ProfileViewModel = viewModel()
    val userId by authVm.userIdFlow.collectAsState(initial = null)
    val state = profileVm.user.value

    LaunchedEffect(userId) {
        userId?.let { profileVm.load(it) }
    }

    when {
        state.loading -> Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) { CircularProgressIndicator() }
        state.error != null -> Text(state.error ?: "Error", modifier = Modifier.padding(16.dp))
        else -> {
            val u = state.data
            Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Profile")
                Text("${u?.firstName ?: ""} ${u?.lastName ?: ""}")
                Text(u?.email ?: "")
                Text("@${u?.username ?: ""}")
            }
        }
    }
}


