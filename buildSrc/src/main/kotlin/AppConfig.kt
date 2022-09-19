object AppConfig {
    const val id = "com.ppizil.Cooflix"

    //버전 코드 기준 -> 1씩 추가
    const val versionCode = 1
    const val versionName = "v1.0.0"

    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val buildToolsVersion = "30.0.2"
}

object GradlePluginId {
    const val ANDROID_APP = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"

    const val kotlin = "kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-parcelize"
    const val hilt = "dagger.hilt.android.plugin"
    const val safeArg = "androidx.navigation.safeargs.kotlin"
}


object GradleClasspath {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePluginClasspath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltPlugin}"
    const val safeArgNavi = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}