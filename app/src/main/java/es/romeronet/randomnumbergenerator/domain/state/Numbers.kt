package es.romeronet.randomnumbergenerator.domain.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import es.romeronet.randomnumbergenerator.domain.number.Number

object Numbers {
    var numbers: MutableState<Array<Number>> = mutableStateOf(arrayOf())
}
