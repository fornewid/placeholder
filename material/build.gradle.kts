plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.android.kotlin.get().pluginId)
    id(libs.plugins.jetbrains.dokka.get().pluginId)
    id(libs.plugins.gradle.metalava.get().pluginId)
    id(libs.plugins.vanniktech.maven.publish.get().pluginId)
}

kotlin {
    explicitApi()
}

android {
    namespace = "io.github.fornewid.placeholder.material"

    compileSdk = 34

    defaultConfig {
        minSdk = 21
        // targetSdkVersion has no effect for libraries. This is only used for the test APK
        targetSdk = 33
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
        disable += setOf("GradleOverrides")
    }

    packaging {
        // Some of the META-INF files conflict with coroutines-test. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources {
            excludes += listOf("/META-INF/AL2.0", "/META-INF/LGPL2.1")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        animationsDisabled = true
    }
}

metalava {
    sourcePaths.setFrom("src/main")
    filename.set("api/current.api")
    reportLintsAsErrors.set(true)
}

dependencies {
    implementation(libs.compose.material.material)
    api(project(":foundation"))

    // ======================
    // Test dependencies
    // ======================

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.truth)

    androidTestImplementation(libs.compose.ui.test.junit4)
    androidTestImplementation(libs.compose.ui.test.manifest)
    androidTestImplementation(libs.compose.foundation.foundation)

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.runner)
}
