plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.kotlinAndroid)
    id(GradlePluginId.kotlinKapt)
    id(GradlePluginId.kotlinAndroidExtensions)
    id(GradlePluginId.hilt)

}
android{
    compileSdk = AppConfig.compileSdk
    buildToolsVersion =AppConfig.buildToolsVersion

}

dependencies {
    implementation(project(Modules.domain))
    api(project(Modules.share))

    implementationList(LibraryList.RetrofitLibraries)

    implementationList(LibraryList.HiltLibraries)
    kaptList(LibraryList.HiltLibraryKapt)

}
