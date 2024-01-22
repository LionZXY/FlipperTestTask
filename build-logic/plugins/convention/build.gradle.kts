plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle)
    implementation(libs.kotlin.ksp.gradle)
    implementation(libs.square.anvil.gradle)

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
