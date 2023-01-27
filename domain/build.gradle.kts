plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}


dependencies {
    // Inject
    implementation(Dependencies.Javax.inject)

    // Coroutine
    implementation(Dependencies.Coroutines.core)
}