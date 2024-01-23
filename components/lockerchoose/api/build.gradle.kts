plugins {
    id("flipper.android-lib")
    id("flipper.anvil")
}

android.namespace = "com.lionzxy.flippertesttask.lockerchoose.api"

dependencies {
    implementation(projects.components.core.decompose)
    implementation(libs.decompose)
}
