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
package io.github.fornewid.placeholder.sample.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import coil3.compose.rememberAsyncImagePainter
import io.github.fornewid.placeholder.foundation.PlaceholderHighlight
import io.github.fornewid.placeholder.material.fade
import io.github.fornewid.placeholder.material.placeholder
import io.github.fornewid.placeholder.sample.randomSampleImageUrl
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource
import placeholder.sample.shared.generated.resources.Res
import placeholder.sample.shared.generated.resources.material_title_fade

@Composable
fun PlaceholderMaterialFadeSample() {
    SampleTheme {
        Sample()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Sample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(Res.string.material_title_fade)) },
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
                        // We're using the modifier provided by placeholder-material which
                        // uses good default values for the color
                        childModifier = Modifier.placeholder(
                            visible = refreshing,
                            highlight = PlaceholderHighlight.fade(),
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