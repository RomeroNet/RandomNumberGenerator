package es.romeronet.randomnumbergenerator.infrastructure.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.romeronet.randomnumbergenerator.domain.number.Number

class Number {
    @Composable
    fun Print(number: Number) {
        Text(number.value.toString(), Modifier.padding(horizontal = 1.dp))
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        val number = Number(23)
        Print(number)
    }
}