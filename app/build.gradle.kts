import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.jetbrains.kotlin.cli.jvm.main

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}


android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.ositnikov.testcoroutines"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), ("proguard-rules.pro"))
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
}

dependencies {
    /** main */
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.11")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.1.0-alpha03")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    /** coroutines */
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")

    /** test */
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}
