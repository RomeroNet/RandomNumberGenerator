package es.romeronet.randomnumbergenerator.infrastructure.activity

import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onChildAt
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AboutActivityTest {
    @get:Rule
    val rule = createAndroidComposeRule<AboutActivity>()

    @Test
    fun itShouldDisplayUI() {
        rule
            .onNode(hasTestTag("AboutTopBar"))
            .assertExists()

        rule
            .onNode(hasTestTag("AboutTopBar"))
            .onChildAt(0)
            .assertExists()
            .assertHasClickAction()
            .assertContentDescriptionEquals("Go back")

        rule
            .onNode(hasTestTag("AboutTopBar"))
            .onChildAt(1)
            .assertExists()
            .assertTextEquals("Random Number Generator")

        rule
            .onNode(hasTestTag("Column"))
            .assertExists()
            .onChild()
            .assertExists()
            .assertTextEquals("hihi")
    }
}