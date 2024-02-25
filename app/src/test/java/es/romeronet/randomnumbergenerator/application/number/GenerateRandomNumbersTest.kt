package es.romeronet.randomnumbergenerator.application.number

import org.junit.Assert
import org.junit.Test

class GenerateRandomNumbersTest {

    @Test
    fun itShouldGenerateNumbers() {
        val numbers = GenerateRandomNumbers().generate(5)

        Assert.assertEquals(5, numbers.size)
    }

    @Test
    fun itShouldGenerateNumbersInRange() {
        val numbers = GenerateRandomNumbers().generate(5, 5)

        numbers.forEach {
            Assert.assertTrue(it.value <= 5)
            Assert.assertTrue(it.value > 0)
        }
    }

    @Test
    fun itShouldGenerateUniqueNumbers() {
        val numbers = GenerateRandomNumbers().generate(5, 5)
        var primitiveNumbers: Array<Int> = arrayOf()

        numbers.forEach {
            primitiveNumbers += it.value
        }

        val filteredNumbers = numbers.distinct()

        Assert.assertEquals(5, filteredNumbers.size)
    }
}