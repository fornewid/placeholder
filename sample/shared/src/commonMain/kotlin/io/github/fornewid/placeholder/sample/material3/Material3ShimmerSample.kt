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
package io.github.fornewid.placeholder.sample.material3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import coil3.compose.rememberAsyncImagePainter
import io.github.fornewid.placeholder.foundation.PlaceholderHighlight
import io.github.fornewid.placeholder.material3.placeholder
import io.github.fornewid.placeholder.material3.shimmer
import io.github.fornewid.placeholder.sample.StringResources
import io.github.fornewid.placeholder.sample.randomSampleImageUrl
import kotlinx.coroutines.delay

@Composable
fun Material3ShimmerSample(upPress: () -> Unit) {
    SampleTheme {
        Sample(upPress = upPress)
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
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
                title = { Text(StringResources.material3_title_shimmer) },
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
                        // We're using the modifier provided by placeholder-material3 which
                        // uses good default values for the color
                        childModifier = Modifier.placeholder(
                            visible = refreshing,
                            highlight = PlaceholderHighlight.shimmer(),
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
