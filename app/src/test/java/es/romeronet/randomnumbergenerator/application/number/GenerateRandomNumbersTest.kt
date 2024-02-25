package es.romeronet.randomnumbergenerator.application.number

import org.junit.Assert
import org.junit.Test

class GenerateRandomNumbersTest {

    @Test
    fun itShouldGenerateNumbers() {
        val numbers = GenerateRandomNumbers().generate(5)

        Assert.assertEquals(numbers.size, 5)
    }

    @Test
    fun itShouldGenerateNumbersBelowMax() {
        val numbers = GenerateRandomNumbers().generate(50, 5)

        numbers.forEach {
            Assert.assertTrue(it.value <= 5)
        }
    }
}