plugins {
    id("placeholder.android.application")
    id("placeholder.android.compose")
    alias(libs.plugins.dependencyGuard)
}

android {
    namespace = "io.github.fornewid.placeholder.sample"

    defaultConfig {
        applicationId = "io.github.fornewid.placeholder.sample"

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(project(":foundation"))
    implementation(project(":material"))
    implementation(project(":material3"))

    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutines.android)

    implementation(libs.compose.material.material)
    implementation(libs.compose.material.iconsext)
    implementation(libs.compose.material3.material3)
    implementation(libs.compose.foundation.layout)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.ui.util)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core)

    implementation(libs.coil.compose)
}

dependencyGuard {
    // All dependencies included in Production Release APK
    configuration("releaseRuntimeClasspath")
}
