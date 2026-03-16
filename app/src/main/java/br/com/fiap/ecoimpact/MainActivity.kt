package br.com.fiap.ecoimpact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoimpact.model.ActionItem
import br.com.fiap.ecoimpact.screens.ActionScreen
import br.com.fiap.ecoimpact.screens.HistoryScreen
import br.com.fiap.ecoimpact.screens.HomeScreen
import br.com.fiap.ecoimpact.screens.ResultScreen
import br.com.fiap.ecoimpact.screens.TipsScreen
import br.com.fiap.ecoimpact.ui.theme.EcoImpactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoImpactTheme {
                val navController = rememberNavController()
                val actions = remember {
                    mutableStateListOf(
                        ActionItem("Dirigir carro", 2.3, "🚗"),
                        ActionItem("Viajar de avião", 8.5, "✈️"),
                        ActionItem("Comer carne", 1.5, "🍔"),
                        ActionItem("Andar de bicicleta", 0.0, "🚲"),
                        ActionItem("Usar transporte público", 0.8, "🚌")
                    )
                }

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onStartClick = { navController.navigate("actions") }
                        )
                    }

                    composable("actions") {
                        ActionScreen(
                            actions = actions,
                            onToggleAction = { index ->
                                actions[index] = actions[index].copy(
                                    selected = !actions[index].selected
                                )
                            },
                            onCalculateClick = { navController.navigate("result") }
                        )
                    }

                    composable("result") {
                        ResultScreen(
                            actions = actions,
                            onTipsClick = { navController.navigate("tips") },
                            onHistoryClick = { navController.navigate("history") }
                        )
                    }

                    composable("tips") {
                        TipsScreen(
                            onHistoryClick = { navController.navigate("history") }
                        )
                    }

                    composable("history") {
                        HistoryScreen(
                            onHomeClick = {
                                navController.navigate("home") {
                                    popUpTo("home") { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}