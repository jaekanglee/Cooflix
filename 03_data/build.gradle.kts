import java.io.FileInputStream
import java.util.Properties

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

        val config = rootProject.file("./config/config.properties")
        val properties = Properties()
        properties.load(FileInputStream(config))
        properties.onEach { item ->
            buildConfigField("String", "${item.key}", "\"${item.value}\"")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.share))

    apiList(LibraryList.RetrofitLibraries)


    implementationList(LibraryList.HiltLibraries)
    kaptList (LibraryList.HiltLibraryKapt)

    testImplementationList(LibraryList.testImplementation)
    runTimeOnlyList(LibraryList.testRuntimeOnly)

    testImplementationList(LibraryList.hiltTestsimpl)
    // ...with Kotlin.
    kaptTestList(LibraryList.hiltKaptImpl)
}
