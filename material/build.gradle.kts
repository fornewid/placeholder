plugins {
    id("placeholder.android.library")
    id("placeholder.kotlin.multiplatform")
    id("placeholder.compose")
    alias(libs.plugins.jetbrains.dokka)
    id("placeholder.metalava")
    alias(libs.plugins.maven.publish)
}

kotlin {
    explicitApi()
    sourceSets {
        commonMain.dependencies {
            api(projects.foundation)
            implementation(compose.material)
            implementation(libs.androidx.annotation)
        }
    }
}

android {
    namespace = "io.github.fornewid.placeholder.material"
}
