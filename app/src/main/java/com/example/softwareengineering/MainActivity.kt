package com.example.softwareengineering

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.softwareengineering.ui.theme.SoftwareEngineeringTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Firebase.auth.signInWithEmailAndPassword("test@gmail.com", "mytest").addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Firebase", "signInWithEmail:success")
            } else {
                Log.e("Firebase", "signInWithEmail:failure", task.exception)
            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoftwareEngineeringTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SoftwareEngineeringTheme {
//        isi
    }
}