package es.romeronet.randomnumbergenerator.infrastructure.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.romeronet.randomnumbergenerator.infrastructure.routing.Routes
import es.romeronet.randomnumbergenerator.infrastructure.routing.RoutingState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Router()
        }
    }
}

@Composable
fun Router() {
    val navController = getOrCreateNavControllerFromState()

    NavHost(
        navController = navController,
        startDestination = Routes.Numbers.value
    ) {
        composable(Routes.Numbers.value) {
            Numbers()
        }
        composable(Routes.About.value) {
            About()
        }
    }
}

@Composable
fun getOrCreateNavControllerFromState(): NavHostController {
    if (! RoutingState.isInitialized()) {
        RoutingState.navController = rememberNavController()
    }

    return RoutingState.navController
}

@Preview
@Composable
fun RouterPreview() {
    Router()
}
