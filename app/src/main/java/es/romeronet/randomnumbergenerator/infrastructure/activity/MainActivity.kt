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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.romeronet.randomnumbergenerator.application.number.GenerateRandomNumbers
import es.romeronet.randomnumbergenerator.infrastructure.component.Number
import es.romeronet.randomnumbergenerator.infrastructure.component.RegenerateButton
import es.romeronet.randomnumbergenerator.ui.theme.RandomNumberGeneratorTheme
import es.romeronet.randomnumbergenerator.domain.state.Numbers as NumbersState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NumbersState.numbers.value = GenerateRandomNumbers().generate(5)
        enableEdgeToEdge()
        setContent {
            Numbers()
        }
    }
}

@Composable
fun Numbers() {
    RandomNumberGeneratorTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (number in NumbersState.numbers.value) {
                        Number().Print(number)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 40.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    RegenerateButton().Print()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NumbersPreview() {
    NumbersState.numbers.value = GenerateRandomNumbers().generate(5)
    Numbers()
}