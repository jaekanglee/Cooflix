plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.HILT)
    kotlin(GradlePlugin.KAPT)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION
}

dependencies {
    implementation(project(Module.CORE))
    implementation(project(Module.DOMAIN))

    implementation(Libraries.HILT)
    kapt(Libraries.HILT_ANNOTATION)

    implementation(Libraries.CORE_KTX)
    implementation(Libraries.ACTIVITY_KTX)
    implementation(Libraries.APPCOMPAT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.CONSTRAINTLAYOUT)

    implementation(Libraries.COROUTINES_CORE)
    implementation(Libraries.COROUTINES_ANDROID)
    implementation(Libraries.LIFECYCLE_VIEWMODEL_KTX)
}