package com.simtop.simdiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.simtop.simdiary.ui.theme.SimDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimDiaryTheme {
                val navController = rememberNavController()
                SetupNavGraph(
                    startDestination = Screen.Home,
                    navController = navController
                )
            }
        }
    }
}