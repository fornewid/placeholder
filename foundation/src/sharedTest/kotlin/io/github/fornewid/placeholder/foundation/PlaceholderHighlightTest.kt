package io.github.fornewid.placeholder.foundation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.fornewid.placeholder.foundation.PlaceholderHighlight
import io.github.fornewid.placeholder.foundation.fade
import io.github.fornewid.placeholder.foundation.shimmer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlaceholderHighlightTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun fadeBrush() {
        composeTestRule.setContent {
            PlaceholderHighlight.fade(highlightColor = Color.Blue)
        }
    }

    @Test
    fun shimmerBrush() {
        composeTestRule.setContent {
            PlaceholderHighlight.shimmer(highlightColor = Color.Blue)
        }
    }

    @Test
    fun fadeBrush_equals() {
        assertThat(PlaceholderHighlight.fade(highlightColor = Color.Blue))
            .isEqualTo(PlaceholderHighlight.fade(highlightColor = Color.Blue))
    }

    @Test
    fun shimmerBrush_equals() {
        assertThat(PlaceholderHighlight.shimmer(highlightColor = Color.Blue))
            .isEqualTo(PlaceholderHighlight.shimmer(highlightColor = Color.Blue))
    }
}
