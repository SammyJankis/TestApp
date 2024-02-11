plugins {
    kotlin("jvm")
}

dependencies{
    implementation(project(":feature:notifications:domain"))
    implementation(libs.coroutines.core)
    implementation(libs.java.inject)
}
