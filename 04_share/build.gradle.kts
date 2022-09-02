plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.kotlinAndroid)
    id(GradlePluginId.kotlinKapt)
    id(GradlePluginId.kotlinAndroidExtensions)
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion =AppConfig.buildToolsVersion

}

dependencies {
    implementationList(LibraryList.coroutines)
}