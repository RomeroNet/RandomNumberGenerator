package es.romeronet.randomnumbergenerator.infrastructure.routing

import androidx.navigation.NavHostController

object RoutingState {
    lateinit var navController: NavHostController

    fun isInitialized(): Boolean {
        return this::navController.isInitialized
    }
}
