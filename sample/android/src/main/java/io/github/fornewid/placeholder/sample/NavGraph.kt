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
import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    object Home : Destination

    @Serializable
    object PlaceholderFoundationBasic : Destination

    @Serializable
    object PlaceholderFoundationFade : Destination

    @Serializable
    object PlaceholderFoundationShimmer : Destination

    @Serializable
    object PlaceholderMaterialBasic : Destination

    @Serializable
    object PlaceholderMaterialFade : Destination

    @Serializable
    object PlaceholderMaterialShimmer : Destination

    @Serializable
    object PlaceholderMaterial3Basic : Destination

    @Serializable
    object PlaceholderMaterial3Fade : Destination

    @Serializable
    object PlaceholderMaterial3Shimmer : Destination
}

@Composable
fun NavGraph(
    startDestination: Destination = Destination.Home,
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
        composable<Destination.Home> {
            HomeScreen(
                onItemClick = {
                    navController.navigate(route = it)
                },
            )
        }

        // foundation
        composable<Destination.PlaceholderFoundationBasic> {
            PlaceholderBasicSample()
        }
        composable<Destination.PlaceholderFoundationFade> {
            PlaceholderFadeSample()
        }
        composable<Destination.PlaceholderFoundationShimmer> {
            PlaceholderShimmerSample()
        }

        // material
        composable<Destination.PlaceholderMaterialBasic> {
            PlaceholderMaterialBasicSample()
        }
        composable<Destination.PlaceholderMaterialFade> {
            PlaceholderMaterialFadeSample()
        }
        composable<Destination.PlaceholderMaterialShimmer> {
            PlaceholderMaterialShimmerSample()
        }

        // material3
        composable<Destination.PlaceholderMaterial3Basic> {
            PlaceholderMaterial3BasicSample()
        }
        composable<Destination.PlaceholderMaterial3Fade> {
            PlaceholderMaterial3FadeSample()
        }
        composable<Destination.PlaceholderMaterial3Shimmer> {
            PlaceholderMaterial3ShimmerSample()
        }
    }
}
