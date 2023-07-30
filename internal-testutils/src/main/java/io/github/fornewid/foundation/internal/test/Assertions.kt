package io.github.fornewid.foundation.internal.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toPixelMap
import com.google.common.truth.Truth.assertThat

/**
 * Assert that all of the pixels in this image as of the [expected] color.
 */
fun ImageBitmap.assertPixels(expected: Color, tolerance: Float = 0.001f) {
    toPixelMap().buffer.forEach { pixel ->
        val color = Color(pixel)
        assertThat(color.red).isWithin(tolerance).of(expected.red)
        assertThat(color.green).isWithin(tolerance).of(expected.green)
        assertThat(color.blue).isWithin(tolerance).of(expected.blue)
        assertThat(color.alpha).isWithin(tolerance).of(expected.alpha)
    }
}
