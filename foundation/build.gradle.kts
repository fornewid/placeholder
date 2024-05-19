plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.jetbrains.dokka)
    alias(libs.plugins.metalava)
    alias(libs.plugins.maven.publish)
}

kotlin {
    explicitApi()
}

android {
    namespace = "io.github.fornewid.placeholder.foundation"

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
        unitTests.all {
            it.useJUnit {
                excludeCategories("io.github.fornewid.placeholder.internal.test.IgnoreOnRobolectric")
            }
        }
        animationsDisabled = true
    }

    sourceSets {
        named("test") {
            java.srcDirs("src/sharedTest/kotlin")
            res.srcDirs("src/sharedTest/res")
        }
        named("androidTest") {
            java.srcDirs("src/sharedTest/kotlin")
            res.srcDirs("src/sharedTest/res")
        }
    }
}

metalava {
    sourcePaths.setFrom("src/main")
    filename.set("api/current.api")
    reportLintsAsErrors.set(true)
}

dependencies {
    implementation(libs.compose.foundation.foundation)
    implementation(libs.compose.ui.util)

    // ======================
    // Test dependencies
    // ======================

    androidTestImplementation(project(":internal-testutils"))
    testImplementation(project(":internal-testutils"))

    androidTestImplementation(libs.junit)
    testImplementation(libs.junit)

    androidTestImplementation(libs.truth)
    testImplementation(libs.truth)

    androidTestImplementation(libs.compose.ui.test.junit4)
    testImplementation(libs.compose.ui.test.junit4)

    androidTestImplementation(libs.compose.ui.test.manifest)
    testImplementation(libs.compose.ui.test.manifest)

    androidTestImplementation(libs.androidx.test.runner)
    testImplementation(libs.androidx.test.runner)

    testImplementation(libs.robolectric)
}
