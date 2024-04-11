package es.romeronet.randomnumbergenerator.infrastructure.component

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import es.romeronet.randomnumbergenerator.domain.state.Numbers
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegenerateButtonTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun itShouldCreate() {
        rule
            .setContent {
                RegenerateButton().Print()
            }

        rule
            .onNode(hasText("Generate again"))
            .assertHasClickAction()
    }

    @Test
    fun itShouldUpdateState() {
        Numbers.reset()
        val state = Numbers.numbers

        val beforeSettingValues = state.value

        rule
            .setContent {
                RegenerateButton().Print()
            }

        rule
            .onNode(hasText("Generate again"))
            .performClick()

        val afterSettingValues = state.value

        Assert.assertEquals(0, beforeSettingValues.size)
        Assert.assertEquals(5, afterSettingValues.size)
    }

    @Test
    fun itShouldPreview() {
        rule
            .setContent {
                RegenerateButton().Preview()
            }

        rule
            .onNode(hasText("Generate again"))
            .assertHasClickAction()
    }
}