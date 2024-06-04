plugins {
    id("placeholder.android.library")
    id("placeholder.kotlin.multiplatform")
    id("placeholder.compose")
}

android {
    namespace = "io.github.fornewid.placeholder.internal.test"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.foundation)
        }
        androidMain.dependencies {
            api(libs.compose.ui.test.junit4)

            api(libs.androidx.test.core)
            implementation(libs.truth)
        }
    }
}
