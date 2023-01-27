import Plugins.Kotlin.kapt

plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.yrys.kotlin5group47lesson1"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Modules
    implementation(project(":domain"))

    // Android
    implementation(Dependencies.UI.androidCore)

    // Javax
    implementation(Dependencies.Javax.inject)

    // Room
    implementation(Dependencies.Room.room)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)

    // Coroutines
    implementation(Dependencies.Coroutines.android)
}