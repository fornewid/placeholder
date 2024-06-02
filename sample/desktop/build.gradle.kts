plugins {
    id("placeholder.kotlin.multiplatform")
    id("placeholder.compose")
}

kotlin {
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(projects.sample.shared)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "io.github.fornewid.placeholder.sample.desktop.MainKt"
    }
}
