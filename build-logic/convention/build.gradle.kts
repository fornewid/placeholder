plugins {
    `kotlin-dsl`
}

group = "io.github.fornewid.placeholder.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.android.pluginGradle)
    implementation(libs.kotlin.pluginGradle)
    implementation(libs.compose.compiler.pluginGradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "placeholder.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "placeholder.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("kotlinAndroid") {
            id = "placeholder.kotlin.android"
            implementationClass = "KotlinAndroidConventionPlugin"
        }
        register("kotlinMultiplatform") {
            id = "placeholder.kotlin.multiplatform"
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }
        register("compose") {
            id = "placeholder.compose"
            implementationClass = "ComposeMultiplatformConventionPlugin"
        }
    }
}
