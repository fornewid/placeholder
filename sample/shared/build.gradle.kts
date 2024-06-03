plugins {
    id("placeholder.android.library")
    id("placeholder.kotlin.multiplatform")
    id("placeholder.compose")
}

android {
    namespace = "io.github.fornewid.placeholder.shared"
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    macosX64 {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    macosArm64 {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.foundation)
            implementation(projects.material)
            implementation(projects.material3)

            implementation(libs.kotlin.stdlib)
            implementation(libs.kotlinx.coroutines.core)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.jetbrains.navigation.compose)

            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.ktor.core)
        }
        androidMain.dependencies {
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.cio)
        }
        jvmMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.cio)
        }
        iosMain.dependencies {
            implementation(libs.ktor.darwin)
        }
        macosMain.dependencies {
            implementation(libs.ktor.cio)
        }
    }
}
