package es.romeronet.randomnumbergenerator.application.number

import org.junit.Assert.assertEquals
import org.junit.Test

class GenerateRandomNumbersTest {

    @Test
    fun itShouldGenerateNumbers() {
        val numbers = GenerateRandomNumbers().generate(5)

        assertEquals(numbers.size, 5)
    }
}