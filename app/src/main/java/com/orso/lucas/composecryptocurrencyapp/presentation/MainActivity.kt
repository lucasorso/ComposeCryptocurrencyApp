package com.orso.lucas.composecryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.orso.lucas.composecryptocurrencyapp.presentation.detail.component.CoinDetailsScreen
import com.orso.lucas.composecryptocurrencyapp.presentation.listItem.component.CoinListScreen
import com.orso.lucas.composecryptocurrencyapp.presentation.ui.theme.ComposeCryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCryptocurrencyAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route,
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailsScreen.route.plus("/{coinId}")
                        ) {
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
