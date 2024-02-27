package es.romeronet.randomnumbergenerator.infrastructure.activity

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NumbersActivityTest {
    @get:Rule
    val rule = createAndroidComposeRule<NumbersActivity>()

    @Test
    fun itShouldDisplayUI() {
        rule
            .onNode(hasTestTag("HomeTopBar"))
            .assertExists()

        rule
            .onNode(hasTestTag("HomeTopBar"))
            .onChildAt(0)
            .assertExists()
            .assertTextEquals("Random Number Generator")

        rule
            .onNode(hasTestTag("HomeTopBar"))
            .onChildAt(1)
            .assertExists()
            .assertHasClickAction()
            .assertContentDescriptionEquals("About this app")

        rule
            .onNode(hasTestTag("NumbersRow"))
            .assertExists()
            .onChildren()
            .assertCountEquals(5)

        rule
            .onNode(hasTestTag("ButtonRow"))
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

        rule
            .onNode(hasTestTag("NumbersRow"))
            .onChildren()
            .fetchSemanticsNodes()
            .forEach {
                startValues += it.config[SemanticsProperties.Text][0].text.toInt()
            }

        rule
            .onNode(hasTestTag("ButtonRow"))
            .onChild()
            .performClick()

        rule
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