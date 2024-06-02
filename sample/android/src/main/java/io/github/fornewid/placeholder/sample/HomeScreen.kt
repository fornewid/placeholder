package io.github.fornewid.placeholder.sample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

private data class Demo(
    val title: String,
    val destination: Destination,
)

@Composable
fun HomeScreen(onItemClick: (Destination) -> Unit) {
    val items: List<Demo> = listOf(
        Demo(
            title = stringResource(R.string.foundation_title_basics),
            destination = Destination.PlaceholderFoundationBasic,
        ),
        Demo(
            title = stringResource(R.string.foundation_title_fade),
            destination = Destination.PlaceholderFoundationFade,
        ),
        Demo(
            title = stringResource(R.string.foundation_title_shimmer),
            destination = Destination.PlaceholderFoundationShimmer,
        ),
        Demo(
            title = stringResource(R.string.material_title_basics),
            destination = Destination.PlaceholderMaterialBasic,
        ),
        Demo(
            title = stringResource(R.string.material_title_fade),
            destination = Destination.PlaceholderMaterialFade,
        ),
        Demo(
            title = stringResource(R.string.material_title_shimmer),
            destination = Destination.PlaceholderMaterialShimmer,
        ),
        Demo(
            title = stringResource(R.string.material3_title_basics),
            destination = Destination.PlaceholderMaterial3Basic,
        ),
        Demo(
            title = stringResource(R.string.material3_title_fade),
            destination = Destination.PlaceholderMaterial3Fade,
        ),
        Demo(
            title = stringResource(R.string.material3_title_shimmer),
            destination = Destination.PlaceholderMaterial3Shimmer,
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.surface,
            )
        },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = contentPadding,
        ) {
            items(
                items = items,
                contentType = { "Demo" },
            ) { demo ->
                HomeDemoItem(demo, onItemClick = onItemClick)
                Divider()
            }
        }
    }
}

@Composable
private fun HomeDemoItem(
    demo: Demo,
    onItemClick: (Destination) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(48.dp)
            .clickable { onItemClick(demo.destination) }
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = demo.title,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.subtitle1,
        )
    }
}
