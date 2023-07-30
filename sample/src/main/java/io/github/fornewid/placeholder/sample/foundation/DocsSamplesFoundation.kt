package io.github.fornewid.placeholder.sample.foundation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.fornewid.placeholder.foundation.PlaceholderHighlight
import io.github.fornewid.placeholder.foundation.fade
import io.github.fornewid.placeholder.foundation.placeholder
import io.github.fornewid.placeholder.foundation.shimmer

@Composable
fun DocSample_Foundation_Placeholder() {
    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                // optional, defaults to RectangleShape
                shape = RoundedCornerShape(4.dp),
            )
    )
}

@Composable
fun DocSample_Foundation_PlaceholderFade() {
    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                // optional, defaults to RectangleShape
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.fade(
                    highlightColor = Color.White,
                ),
            )
    )
}

@Composable
fun DocSample_Foundation_PlaceholderShimmer() {
    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                // optional, defaults to RectangleShape
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                ),
            )
    )
}
