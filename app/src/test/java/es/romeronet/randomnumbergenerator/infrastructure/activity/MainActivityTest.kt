package es.romeronet.randomnumbergenerator.infrastructure.activity

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun itShouldDisplayUI() {
        rule
            .onNode(hasTestTag("HomeTopBar"))
            .assertExists()
    }
//
//    @Test
//    fun itShouldNavigate() {
//        rule
//            .onNode(hasTestTag("HomeTopBar"))
//            .assertExists()
//
//        rule
//            .onNode(hasTestTag("HomeTopBar"))
//            .onChildAt(1)
//            .performClick()
//
//        rule
//            .onNode(hasTestTag("AboutTopBar"))
//            .assertExists()
//
//        rule
//            .onNode(hasTestTag("AboutTopBar"))
//            .onChildAt(1)
//            .performClick()
//
//        rule
//            .onNode(hasTestTag("HomeTopBar"))
//            .assertExists()
//    }
}