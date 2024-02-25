package es.romeronet.randomnumbergenerator.application.number

import es.romeronet.randomnumbergenerator.domain.number.Number

class GenerateRandomNumbers {
    fun generate(count: Int, max: Int = 90): Array<Number>
    {
        var result: Array<Number> = arrayOf()
        var usedNumbers : Array<Int> = arrayOf()

        for (i in 0..<count) {
            var number: Int

            do {
                number = generateInt(max)
            } while (number in usedNumbers)

            usedNumbers += number
            result += Number(number)
        }
        return result
    }

    private fun generateInt(max: Int): Int {
        return (1..max).random()
    }
}