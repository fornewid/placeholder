/*
 * Copyright 2023 fornewid
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
package io.github.fornewid.placeholder.sample.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import io.github.fornewid.placeholder.foundation.PlaceholderHighlight
import io.github.fornewid.placeholder.foundation.placeholder
import io.github.fornewid.placeholder.foundation.shimmer
import io.github.fornewid.placeholder.sample.StringResources
import io.github.fornewid.placeholder.sample.material.HeaderItem
import io.github.fornewid.placeholder.sample.material.ListItem
import io.github.fornewid.placeholder.sample.randomSampleImageUrl
import kotlinx.coroutines.delay

@Composable
fun FoundationShimmerSample(upPress: () -> Unit) {
    SampleTheme {
        Sample(upPress = upPress)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Sample(upPress: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = upPress) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = null,
                        )
                    }
                },
                title = { Text(StringResources.foundation_title_shimmer) },
                backgroundColor = MaterialTheme.colors.surface,
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        // Simulate a fake 2-second 'load'. Ideally this 'refreshing' value would
        // come from a ViewModel or similar
        var refreshing by remember { mutableStateOf(false) }
        LaunchedEffect(refreshing) {
            if (refreshing) {
                delay(4000)
                refreshing = false
            }
        }

        val state = rememberPullRefreshState(
            refreshing = refreshing,
            onRefresh = { refreshing = true },
        )

        Box(Modifier.pullRefresh(state)) {
            LazyColumn(contentPadding = padding) {
                if (refreshing.not()) {
                    item {
                        HeaderItem(
                            painter = rememberVectorPainter(Icons.Default.ArrowDownward),
                            text = "Pull down or click this",
                            modifier = Modifier.clickable { refreshing = true },
                        )
                    }
                }
                items(30) { index ->
                    ListItem(
                        painter = rememberAsyncImagePainter(randomSampleImageUrl(index)),
                        text = "Text",
                        // We're using the modifier provided by placeholder-foundation which
                        // uses good default values for the color
                        childModifier = Modifier.placeholder(
                            visible = refreshing,
                            color = Color.Black.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(4.dp),
                            highlight = PlaceholderHighlight.shimmer(
                                highlightColor = Color.White.copy(alpha = 0.75f),
                            ),
                        ),
                    )
                }
            }

            PullRefreshIndicator(
                refreshing = refreshing,
                state = state,
                modifier = Modifier.align(Alignment.TopCenter),
            )
        }
    }
}
