package es.romeronet.randomnumbergenerator.infrastructure.activity

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onChildren
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
}