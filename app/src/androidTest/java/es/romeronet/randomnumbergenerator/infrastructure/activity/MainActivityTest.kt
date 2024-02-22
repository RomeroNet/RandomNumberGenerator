package es.romeronet.randomnumbergenerator.infrastructure.activity

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.performClick
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun itShouldDisplayUI() {
        composeTestRule
            .onNode(hasTestTag("NumbersRow"))
            .assertExists()
            .onChildren()
            .assertCountEquals(5)

        composeTestRule.onNode(hasTestTag("ButtonRow"))
            .assertExists()
            .onChild()
            .assertExists()
            .assertHasClickAction()
            .assertTextEquals("Generate again")
    }

    @Test
    fun itShouldUpdateNumbersOnGenerateAgain() {
        var startValues: Array<Int> = arrayOf()
        var endValues: Array<Int> = arrayOf()

        composeTestRule
            .onNode(hasTestTag("NumbersRow"))
            .onChildren()
            .fetchSemanticsNodes()
            .forEach {
                startValues += it.config[SemanticsProperties.Text][0].text.toInt()
            }

        composeTestRule
            .onNode(hasTestTag("ButtonRow"))
            .onChild()
            .performClick()

        composeTestRule
            .onNode(hasTestTag("NumbersRow"))
            .onChildren()
            .fetchSemanticsNodes()
            .forEach {
                endValues += it.config[SemanticsProperties.Text][0].text.toInt()
            }

        startValues.forEachIndexed { index: Int, value: Int ->
            Assert.assertNotEquals(value, endValues[index])
        }
    }
}