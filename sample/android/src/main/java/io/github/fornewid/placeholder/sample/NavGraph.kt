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
import io.github.fornewid.placeholder.sample.foundation.PlaceholderBasicSample
import io.github.fornewid.placeholder.sample.foundation.PlaceholderFadeSample
import io.github.fornewid.placeholder.sample.foundation.PlaceholderShimmerSample
import io.github.fornewid.placeholder.sample.material.PlaceholderMaterialBasicSample
import io.github.fornewid.placeholder.sample.material.PlaceholderMaterialFadeSample
import io.github.fornewid.placeholder.sample.material.PlaceholderMaterialShimmerSample
import io.github.fornewid.placeholder.sample.material3.PlaceholderMaterial3BasicSample
import io.github.fornewid.placeholder.sample.material3.PlaceholderMaterial3FadeSample
import io.github.fornewid.placeholder.sample.material3.PlaceholderMaterial3ShimmerSample

sealed class Destination(val route: String) {
    object Home : Destination("Home")
    object PlaceholderFoundationBasic : Destination("PlaceholderFoundationBasic")
    object PlaceholderFoundationFade : Destination("PlaceholderFoundationFade")
    object PlaceholderFoundationShimmer : Destination("PlaceholderFoundationShimmer")
    object PlaceholderMaterialBasic : Destination("PlaceholderMaterialBasic")
    object PlaceholderMaterialFade : Destination("PlaceholderMaterialFade")
    object PlaceholderMaterialShimmer : Destination("PlaceholderMaterialShimmer")
    object PlaceholderMaterial3Basic : Destination("PlaceholderMaterial3Basic")
    object PlaceholderMaterial3Fade : Destination("PlaceholderMaterial3Fade")
    object PlaceholderMaterial3Shimmer : Destination("PlaceholderMaterial3Shimmer")
}

@Composable
fun NavGraph(
    startDestination: String = Destination.Home.route,
) {
    val navController = rememberNavController()
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
        composable(Destination.PlaceholderFoundationBasic.route) {
            PlaceholderBasicSample()
        }
        composable(Destination.PlaceholderFoundationFade.route) {
            PlaceholderFadeSample()
        }
        composable(Destination.PlaceholderFoundationShimmer.route) {
            PlaceholderShimmerSample()
        }

        // material
        composable(Destination.PlaceholderMaterialBasic.route) {
            PlaceholderMaterialBasicSample()
        }
        composable(Destination.PlaceholderMaterialFade.route) {
            PlaceholderMaterialFadeSample()
        }
        composable(Destination.PlaceholderMaterialShimmer.route) {
            PlaceholderMaterialShimmerSample()
        }

        // material3
        composable(Destination.PlaceholderMaterial3Basic.route) {
            PlaceholderMaterial3BasicSample()
        }
        composable(Destination.PlaceholderMaterial3Fade.route) {
            PlaceholderMaterial3FadeSample()
        }
        composable(Destination.PlaceholderMaterial3Shimmer.route) {
            PlaceholderMaterial3ShimmerSample()
        }
    }
}
