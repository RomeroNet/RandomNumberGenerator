package es.romeronet.randomnumbergenerator.application.number

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.arrayWithSize
import org.junit.jupiter.api.Test

class GenerateRandomNumbersTest {

    @Test
    fun itShouldGenerateNumbers() {
        val numbers = GenerateRandomNumbers().generate(5)

        assertThat(numbers, `is`(arrayWithSize(5)))
    }
}