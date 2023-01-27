object Versions {
    const val androidCore = "1.7.0"
    const val appCompat = "1.5.1"
    const val material = "1.7.0"
    const val constraint = "2.1.4"
    const val jUnit = "4.13.2"
    const val extJUnit = "1.1.4"
    const val espresso = "3.5.0"
    const val fragment = "1.5.5"
    const val room = "2.4.3"
    const val daggerHilt = "2.44.2"
    const val AGP = "7.3.0"
    const val kotlin = "1.7.10"
    const val coroutines = "1.6.4"
    const val lifecycle = "2.5.1"
    const val navigation = "2.5.3"
}

object Dependencies {

    object UI {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val room = "androidx.room:room-ktx:${Versions.room}"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
    }

    object Coroutines {
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object ViewBindingDelegate {
        const val delegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

}

object Plugins {
    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val jvm = "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }

    object Java {
        const val library = "java-library"
    }
}