plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "io.github.fornewid.placeholder.sample"

    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.fornewid.placeholder.sample"
        minSdk = 21
        targetSdk = 33

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
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
