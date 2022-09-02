plugins {
    id(GradlePluginId.ANDROID_APP)
    id(GradlePluginId.kotlinAndroid)
    id(GradlePluginId.kotlinKapt)
    id(GradlePluginId.kotlinAndroidExtensions)
    id(GradlePluginId.hilt)
    //id("androidx.navigation.safeargs.kotlin")
}


android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig.apply {
        applicationId = AppConfig.id

        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        //testInstrumentationRunner = "com.kaii.dentii.HiltTestRunner"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        compileOptions {
            // isCoreLibraryDesugaringEnabled=true
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

    }

    testOptions.apply {
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true
    }

    buildTypes {

        release {
            isMinifyEnabled = true
            isDebuggable = false

            manifestPlaceholders["appName"] = "쿠플릭스"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"

        }

        debug {
            isMinifyEnabled = false
            isDebuggable = true

            manifestPlaceholders["appName"] = "쿠플릭스"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"

        }
    }

//
//    kotlinOptions {
//        jvmTarget = Versions.jvmTarget
//        languageVersion = Versions.kotlinLanguageVersion
//    }

    buildFeatures {
        dataBinding = true
    }



    repositories {
        flatDir {
            dirs("libs")
        }
    }

}


dependencies {
    implementation(project(Modules.presentation))
    implementation(project(Modules.domain))
    implementation(project(Modules.data))
    api(project(Modules.share))
    implementation(project(Modules.hardware))

    implementationList(LibraryList.HiltLibraries)
    kaptList(LibraryList.HiltLibraryKapt)

    //implementation(Libraries.naverMap)
    //implementationList(LibraryList.NavigationLibraries)

    implementationList(LibraryList.appLibraries)

    implementationList(LibraryList.Glide)

    implementation(AndroidLibraries.lifecycleViewModel)
}
