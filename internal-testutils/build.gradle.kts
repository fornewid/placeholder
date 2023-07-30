plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.android.kotlin.get().pluginId)
}

android {
    namespace = "io.github.fornewid.placeholder.internal.test"

    compileSdk = 34

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        buildConfig = false
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
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
