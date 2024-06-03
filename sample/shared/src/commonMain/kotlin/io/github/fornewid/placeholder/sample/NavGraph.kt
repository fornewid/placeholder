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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.fornewid.placeholder.sample.foundation.FoundationBasicSample
import io.github.fornewid.placeholder.sample.foundation.FoundationFadeSample
import io.github.fornewid.placeholder.sample.foundation.FoundationShimmerSample
import io.github.fornewid.placeholder.sample.material.MaterialBasicSample
import io.github.fornewid.placeholder.sample.material.MaterialFadeSample
import io.github.fornewid.placeholder.sample.material.MaterialShimmerSample
import io.github.fornewid.placeholder.sample.material3.Material3BasicSample
import io.github.fornewid.placeholder.sample.material3.Material3FadeSample
import io.github.fornewid.placeholder.sample.material3.Material3ShimmerSample

sealed class Destination(val route: String) {
    data object Home : Destination("Home")
    data object FoundationBasic : Destination("FoundationBasic")
    data object FoundationFade : Destination("FoundationFade")
    data object FoundationShimmer : Destination("FoundationShimmer")
    data object MaterialBasic : Destination("MaterialBasic")
    data object MaterialFade : Destination("MaterialFade")
    data object MaterialShimmer : Destination("MaterialShimmer")
    data object Material3Basic : Destination("Material3Basic")
    data object Material3Fade : Destination("Material3Fade")
    data object Material3Shimmer : Destination("Material3Shimmer")
}

@Composable
fun NavGraph(
    startDestination: String = Destination.Home.route,
) {
    val navController = rememberNavController()
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize(),
    ) {
        composable(Destination.Home.route) {
            HomeScreen(
                onItemClick = {
                    navController.navigate(route = it.route)
                },
            )
        }

        // foundation
        composable(Destination.FoundationBasic.route) {
            FoundationBasicSample(upPress = upPress)
        }
        composable(Destination.FoundationFade.route) {
            FoundationFadeSample(upPress = upPress)
        }
        composable(Destination.FoundationShimmer.route) {
            FoundationShimmerSample(upPress = upPress)
        }

        // material
        composable(Destination.MaterialBasic.route) {
            MaterialBasicSample(upPress = upPress)
        }
        composable(Destination.MaterialFade.route) {
            MaterialFadeSample(upPress = upPress)
        }
        composable(Destination.MaterialShimmer.route) {
            MaterialShimmerSample(upPress = upPress)
        }

        // material3
        composable(Destination.Material3Basic.route) {
            Material3BasicSample(upPress = upPress)
        }
        composable(Destination.Material3Fade.route) {
            Material3FadeSample(upPress = upPress)
        }
        composable(Destination.Material3Shimmer.route) {
            Material3ShimmerSample(upPress = upPress)
        }
    }
}
