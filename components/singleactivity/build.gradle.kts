plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
}

android.namespace = "com.lionzxy.flippertesttask.singleactivity"

dependencies {
    implementation(projects.components.core.di)
    implementation(projects.components.core.log)

    implementation(libs.annotations)
    implementation(libs.appcompat)

    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.bundles.decompose)
    implementation(libs.compose.activity)
}
