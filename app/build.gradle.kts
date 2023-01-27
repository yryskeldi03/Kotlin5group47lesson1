plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.yrys.kotlin5group47lesson1"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.yrys.kotlin5group47lesson1"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
// Modules
    implementation(project(":domain"))
    implementation(project(":mylibrary"))

    // UI
    implementation(Dependencies.UI.constraint)
    implementation(Dependencies.UI.androidCore)
    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.material)
    testImplementation(Dependencies.UI.jUnit)
    androidTestImplementation(Dependencies.UI.extJUnit)
    androidTestImplementation(Dependencies.UI.espresso)

    // Javax
    implementation(Dependencies.Javax.inject)

    // Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.viewModel)

    // Navigation
    implementation(Dependencies.Navigation.navUI)
    implementation(Dependencies.Navigation.fragment)

    // ViewBindingDelegate
    implementation(Dependencies.ViewBindingDelegate.delegate)

    // Coroutines
    implementation(Dependencies.Coroutines.android)

    // Dagger-Hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.compiler)

    // Room
    implementation(Dependencies.Room.room)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)
}