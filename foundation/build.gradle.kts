plugins {
    id("placeholder.android.library")
    id("placeholder.kotlin.multiplatform")
    id("placeholder.compose")
    alias(libs.plugins.jetbrains.dokka)
    alias(libs.plugins.metalava)
    alias(libs.plugins.maven.publish)
}

kotlin {
    explicitApi()
    sourceSets {
        commonMain.dependencies {
            implementation(compose.foundation)
            implementation(compose.uiUtil)
            implementation(libs.androidx.annotation)
        }
        val sharedTest by creating {
            dependencies {
                implementation(projects.internalTestutils)
                implementation(libs.junit)
                implementation(libs.truth)
                implementation(libs.compose.ui.test.junit4)
                implementation(libs.compose.ui.test.manifest)
                implementation(libs.androidx.test.runner)
            }
        }
        androidUnitTest {
            dependsOn(sharedTest)
            dependencies {
                implementation(libs.robolectric)
            }
        }
        androidInstrumentedTest {
            dependsOn(sharedTest)
        }
    }
}

android {
    namespace = "io.github.fornewid.placeholder.foundation"

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
