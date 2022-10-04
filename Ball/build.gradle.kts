import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 24
        targetSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDirs("src/androidMain/java")
            res.srcDirs("src/androidMain/res")
        }
    }
}

kotlin {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }
    jvm("desktop")
    android()
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }

        named("androidMain") {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
                implementation ("androidx.core:core-ktx:1.7.0")
                implementation ("androidx.compose.ui:ui:1.1.1")
                implementation ("androidx.compose.material:material:1.1.1")
                implementation ("androidx.compose.ui:ui-tooling-preview:1.1.1")
                implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
                implementation ("androidx.activity:activity-compose:1.3.1")
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }
}
