package io.github.fornewid.placeholder.sample.material

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.fornewid.placeholder.foundation.PlaceholderHighlight
import io.github.fornewid.placeholder.material.fade
import io.github.fornewid.placeholder.material.placeholder
import io.github.fornewid.placeholder.material.shimmer

@Composable
fun DocSample_Material_Placeholder() {
    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(visible = true)
    )
}

@Composable
fun DocSample_Material_PlaceholderFade() {
    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                highlight = PlaceholderHighlight.fade(),
            )
    )
}

@Composable
fun DocSample_Material_PlaceholderShimmer() {
    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                highlight = PlaceholderHighlight.shimmer(),
            )
    )
}
