package io.github.fornewid.placeholder.foundation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PixelMap
import androidx.compose.ui.graphics.toPixelMap
import com.google.common.truth.Truth.assertThat

/**
 * Asserts that the color at a specific pixel in the bitmap at ([x], [y]) is [expected].
 */
fun PixelMap.assertPixelColor(expected: Color, x: Int, y: Int, tolerance: Float = 0.02f) {
    val color = this[x, y]
    assertThat(color.red).isWithin(tolerance).of(expected.red)
    assertThat(color.green).isWithin(tolerance).of(expected.green)
    assertThat(color.blue).isWithin(tolerance).of(expected.blue)
    assertThat(color.alpha).isWithin(tolerance).of(expected.alpha)
}

/**
 * Asserts that the colors at specific pixels in the vertices of bitmap is [expected].
 */
fun ImageBitmap.assertPixelsOfVertices(expected: Color) {
    toPixelMap().run {
        assertPixelColor(expected, 0, 0)
        assertPixelColor(expected, 0, height - 1)
        assertPixelColor(expected, width - 1, 0)
        assertPixelColor(expected, width - 1, height - 1)
    }
}
