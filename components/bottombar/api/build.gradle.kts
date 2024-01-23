plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
}

android.namespace = "com.lionzxy.flippertesttask.bottombar.api"

dependencies {
    implementation(projects.components.core.decompose)

    implementation(libs.compose.ui)
    implementation(libs.decompose)
}
