package es.romeronet.randomnumbergenerator.infrastructure.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import es.romeronet.randomnumbergenerator.R
import es.romeronet.randomnumbergenerator.infrastructure.dependencies.Injector
import es.romeronet.randomnumbergenerator.domain.state.Numbers as NumbersState

class RegenerateButton {
    @Composable
    fun Print() {
        val context = LocalContext.current

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
            NumbersState.numbers.value = Injector.generateRandomNumbers.generate(5)
        }){
            Text(context.getString(R.string.home_regenerate))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        Print()
    }
}