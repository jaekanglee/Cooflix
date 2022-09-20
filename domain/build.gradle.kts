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

    implementation(Libraries.HILT)
    kapt(Libraries.HILT_ANNOTATION)
}