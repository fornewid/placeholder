/*
 * Copyright 2024 fornewid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import androidx.compose.ui.unit.dp

private data class Demo(
    val title: String,
    val destination: Destination,
)

@Composable
fun HomeScreen(onItemClick: (Destination) -> Unit) {
    val items: List<Demo> = listOf(
        Demo(
            title = StringResources.foundation_title_basics,
            destination = Destination.FoundationBasic,
        ),
        Demo(
            title = StringResources.foundation_title_fade,
            destination = Destination.FoundationFade,
        ),
        Demo(
            title = StringResources.foundation_title_shimmer,
            destination = Destination.FoundationShimmer,
        ),
        Demo(
            title = StringResources.material_title_basics,
            destination = Destination.MaterialBasic,
        ),
        Demo(
            title = StringResources.material_title_fade,
            destination = Destination.MaterialFade,
        ),
        Demo(
            title = StringResources.material_title_shimmer,
            destination = Destination.MaterialShimmer,
        ),
        Demo(
            title = StringResources.material3_title_basics,
            destination = Destination.Material3Basic,
        ),
        Demo(
            title = StringResources.material3_title_fade,
            destination = Destination.Material3Fade,
        ),
        Demo(
            title = StringResources.material3_title_shimmer,
            destination = Destination.Material3Shimmer,
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = StringResources.home_title) },
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
