plugins {
    id("placeholder.android.application")
    id("placeholder.kotlin.android")
    id("placeholder.compose")
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
    implementation(projects.sample.shared)
    implementation(libs.androidx.activity.compose)
}
