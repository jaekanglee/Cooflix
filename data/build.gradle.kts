plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.HILT)
    kotlin(GradlePlugin.KAPT)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        resValue("string", "api_key", Properties.API_KEY)
    }
}

dependencies {
    implementation(project(Module.CORE))
    implementation(project(Module.DOMAIN))

    implementation(Libraries.RETROFIT)
    implementation(Libraries.GSON_CONVERTER)
    implementation(Libraries.GSON)
    implementation(platform(Libraries.OKHTTP_BOM))
    implementation(Libraries.OKHTTP)
    implementation(Libraries.INTERCEPTOR)

    implementation(Libraries.HILT)
    kapt(Libraries.HILT_ANNOTATION)
}