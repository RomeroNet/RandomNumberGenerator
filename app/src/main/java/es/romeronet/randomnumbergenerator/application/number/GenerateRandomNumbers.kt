package es.romeronet.randomnumbergenerator.application.number

import es.romeronet.randomnumbergenerator.domain.number.Number

class GenerateRandomNumbers {
    fun generate(count: Int): Array<Number>
    {
        var result = emptyArray<Number>()
        for (i in 0..<count) {
            result += Number((1..90).random())
        }
        return result
    }
}