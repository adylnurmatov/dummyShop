package com.example.dummyshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.dummyshop.ui.navigation.DummyNavHost
import com.example.dummyshop.ui.theme.DummyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DummyTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    DummyNavHost()
                }
            }
        }
    }
}


