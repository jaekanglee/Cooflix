object Libraries {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINTLAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINTLAYOUT}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"

    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
    const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val OKHTTP_BOM = "com.squareup.okhttp3:okhttp-bom:${Versions.OK_HTTP}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp"
    const val INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor"

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANNOTATION = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

}

object TestLibraries {
    const val JUNIT = "junit:junit:4${Versions.JUNIT}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
}

object Versions {
    const val CORE_KTX = "1.7.0"
    const val APPCOMPAT = "1.5.0"
    const val MATERIAL = "1.6.1"
    const val CONSTRAINTLAYOUT = "2.1.4"
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.3"
    const val ESPRESSO = "3.4.0"
    const val COROUTINE = "1.6.4"
    const val LIFECYCLE = "2.5.1"
    const val RETROFIT = "2.9.0"
    const val HILT = "2.43.2"
    const val GSON = "2.8.6"
    const val OK_HTTP = "4.10.0"
    const val ACTIVITY_KTX = "1.5.1"
}