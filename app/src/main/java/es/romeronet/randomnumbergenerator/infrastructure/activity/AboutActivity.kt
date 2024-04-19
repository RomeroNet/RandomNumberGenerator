package es.romeronet.randomnumbergenerator.infrastructure.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import es.romeronet.randomnumbergenerator.R
import es.romeronet.randomnumbergenerator.infrastructure.routing.RoutingState
import es.romeronet.randomnumbergenerator.infrastructure.ui.RandomNumberGeneratorTheme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            About()
        }
    }
}

@Composable
fun About() {
    RandomNumberGeneratorTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AboutTopBar()
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .padding(innerPadding)
                    .testTag("Column")
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(0.4f),
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = LocalContext.current.getString(R.string.about_app_icon)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutTopBar() {
    TopAppBar(
        modifier = Modifier.testTag("AboutTopBar"),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(LocalContext.current.getString(R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = {
                RoutingState.navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go back"
                )
            }
        }
    )
}

@Preview
@Composable
fun AboutPreview() {
    About()
}
