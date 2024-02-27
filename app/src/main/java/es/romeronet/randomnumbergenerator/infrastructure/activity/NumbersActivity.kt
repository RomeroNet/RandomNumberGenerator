package es.romeronet.randomnumbergenerator.infrastructure.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.romeronet.randomnumbergenerator.R
import es.romeronet.randomnumbergenerator.application.number.GenerateRandomNumbers
import es.romeronet.randomnumbergenerator.infrastructure.component.Number
import es.romeronet.randomnumbergenerator.infrastructure.component.RegenerateButton
import es.romeronet.randomnumbergenerator.infrastructure.routing.Routes
import es.romeronet.randomnumbergenerator.infrastructure.routing.RoutingState
import es.romeronet.randomnumbergenerator.ui.theme.RandomNumberGeneratorTheme
import es.romeronet.randomnumbergenerator.domain.state.Numbers as NumbersState

class NumbersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Numbers()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Numbers() {
    fillStateIfEmpty()

    RandomNumberGeneratorTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                NumbersTopBar()
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .testTag("NumbersRow"),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    for (number in NumbersState.numbers.value) {
                        Number().Print(number)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 40.dp)
                        .fillMaxWidth()
                        .testTag("ButtonRow"),
                    horizontalArrangement = Arrangement.Center
                ) {
                    RegenerateButton().Print()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumbersTopBar() {
    TopAppBar(
        modifier = Modifier.testTag("HomeTopBar"),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(LocalContext.current.getString(R.string.app_name))
        },
        actions = {
            IconButton(onClick = {
                RoutingState.navController.navigate(Routes.About.value)
            }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = LocalContext.current.getString(R.string.home_info_button)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun NumbersPreview() {
    NumbersState.numbers.value = GenerateRandomNumbers().generate(5)
    Numbers()
}

fun fillStateIfEmpty() {
    val state = NumbersState.numbers.value

    if (state.isEmpty()) {
        NumbersState.numbers.value = GenerateRandomNumbers().generate(5)
    }
}