plugins {
    id("flipper.android-app")
    id("com.squareup.anvil")
    id("kotlin-kapt")
}

android.namespace = "com.lionzxy.flippertesttask"

dependencies {
    implementation(projects.components.core.di)

    implementation(projects.components.singleactivity)

    implementation(libs.dagger)
    kapt(libs.dagger.kapt)

    implementation(libs.timber)
}
