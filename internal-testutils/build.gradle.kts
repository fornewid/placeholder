plugins {
    id("placeholder.android.library")
    id("placeholder.android.compose")
}

android {
    namespace = "io.github.fornewid.placeholder.internal.test"

    buildFeatures {
        buildConfig = false
    }

    lint {
        textReport = true
        textOutput = File("stdout")
        // We run a full lint analysis as build part in CI, so skip vital checks for assemble tasks
        checkReleaseBuilds = false
    }
    packaging {
        // Certain libraries include licence files in their JARs. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources {
            excludes += listOf("/META-INF/AL2.0", "/META-INF/LGPL2.1")
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)

    implementation(libs.compose.foundation.foundation)
    api(libs.compose.ui.test.junit4)

    api(libs.androidx.test.core)
    implementation(libs.truth)
}
