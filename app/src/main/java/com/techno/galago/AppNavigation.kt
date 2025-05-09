package com.techno.galago

import Plan
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "quick") {
        composable("quick") {
            Quick(navController = navController)
        }

        composable("plan") {
            Plan(navController = navController)
        }

        composable("itinerary") {
            ItineraryPage(navController = navController)
        }
    }
}
