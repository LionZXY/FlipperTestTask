plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
}

android.namespace = "com.lionzxy.flippertesttask.core.decompose"

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)

    implementation(libs.bundles.decompose)
    implementation(libs.essenty.lifecycle.coroutines)
}
