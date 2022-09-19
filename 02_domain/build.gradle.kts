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
    api(project(Modules.share))

    implementationList(LibraryList.HiltLibraries)
    kaptList(LibraryList.HiltLibraryKapt)

    testImplementationList(LibraryList.testImplementation)
    runTimeOnlyList(LibraryList.testRuntimeOnly)
}