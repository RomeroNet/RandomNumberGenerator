package es.romeronet.randomnumbergenerator.infrastructure.component

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import es.romeronet.randomnumbergenerator.domain.number.Number as DomainNumber

@RunWith(AndroidJUnit4::class)
class NumberTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun itShouldDisplayNumber() {
        rule
            .setContent {
            Number().Print(number = DomainNumber(288))
        }

        rule
            .onNode(hasText("288"))
            .assertExists()
    }

    @Test
    fun itShouldPreview() {
        rule
            .setContent {
                Number().Preview()
            }

        rule
            .onNode(hasText("23"))
            .assertExists()
    }
}