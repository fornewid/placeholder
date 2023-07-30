package io.github.fornewid.placeholder.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

/**
 * Simple list item row which displays an image and text.
 */
@Composable
fun ListItem(
    painter: Painter,
    text: String,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
) {
    Row(modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = childModifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp)),
        )

        Spacer(Modifier.width(16.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.subtitle2,
            modifier = childModifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}
