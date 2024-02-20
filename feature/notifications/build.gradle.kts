plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.adidas.notifications"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
}

dependencies {
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.navigation.fragment)

    implementation(libs.hilt.android)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.navigation.compose)
    ksp(libs.hilt.compiler)

    implementation(project(":ui"))
    implementation(project(":analytics"))
    implementation(project(":feature:notifications:domain"))

    testImplementation(libs.junit)
}
