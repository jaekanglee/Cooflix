
plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.kotlinAndroid)
    id(GradlePluginId.kotlinKapt)
    id(GradlePluginId.kotlinAndroidExtensions)
    id(GradlePluginId.hilt)

}


android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig.apply {
        minSdk = AppConfig.minSdk

    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    kapt {
        correctErrorTypes=true
    }
}

dependencies {
    implementation(project(Modules.domain))
    api(project(Modules.share))

    implementationList(LibraryList.RetrofitLibraries)

    implementationList(LibraryList.HiltLibraries)
    kaptList(LibraryList.HiltLibraryKapt)

    testImplementationList(LibraryList.testImplementation)
    runTimeOnlyList(LibraryList.testRuntimeOnly)

    testImplementationList(LibraryList.hiltTestsimpl)
    // ...with Kotlin.
    kaptTestList(LibraryList.hiltKaptImpl)
}
