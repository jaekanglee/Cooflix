plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION
}

dependencies {
    implementation(project(Module.CORE))
    implementation(project(Module.DOMAIN))
}