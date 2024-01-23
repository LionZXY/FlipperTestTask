plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
}

android.namespace = "com.lionzxy.flippertesttask.lockerchoose.impl"

dependencies {
    implementation(projects.components.lockerchoose.api)

    implementation(projects.components.core.di)
    implementation(projects.components.core.decompose)

    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.decompose)

    implementation(libs.kotlin.immutable.collections)
}
