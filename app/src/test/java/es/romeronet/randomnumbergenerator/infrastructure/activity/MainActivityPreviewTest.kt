package es.romeronet.randomnumbergenerator.infrastructure.activity

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityPreviewTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun itShouldDisplayPreview() {
        rule
            .setContent {
                NumbersPreview()
            }
    }
}