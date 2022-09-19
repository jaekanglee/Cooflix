import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Modules {
    const val app = ":app"
    const val presentation = ":01_presentaion"
    const val domain = ":02_domain"
    const val data = ":03_data"
    const val share = ":04_share"
    const val hardware = ":05_hadware"
}

object Libraries {

    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltCore}"
    //const val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidX}"

    // hiltKapt
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hiltCore}"
    //const val hiltAndroidx = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidX}"

    // hiltAnnoation
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltCore}"

    // Coroutine
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$${Versions.coroutine}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"


    // RETROFIT
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"


    // GLIDE
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

}

object TestLibraries {
    val junit = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    val runner = "androidx.test.ext:junit:${Versions.runner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val mokito = "org.mockito:mockito-core:${Versions.mokito}"
    val roboletric = "org.robolectric:robolectric:${Versions.roboletric}"
    val assertj = "org.assertj:assertj-core:${Versions.assertj}"

    val hilt = "com.google.dagger:hilt-android-testing:${Versions.hiltCore}"
    val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltCore}"
}

object AndroidLibraries {
    // ANDROID
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"


    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"

    val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"

}


object LibraryList {
    val testImplementation = arrayListOf<String>().apply {
        add(TestLibraries.junit)
        add(TestLibraries.espresso)
        add(TestLibraries.mokito)
        add(TestLibraries.assertj)
        add(TestLibraries.roboletric)
    }

    val hiltTestsimpl = arrayListOf<String>().apply {
        add(TestLibraries.hilt)
    }

    val hiltKaptImpl = arrayListOf<String>().apply {
        add(TestLibraries.hiltCompiler)
    }

    val testRuntimeOnly = arrayListOf<String>().apply {
        add(TestLibraries.espresso)
    }

    val appLibraries = arrayListOf<String>().apply {
        add(AndroidLibraries.kotlin)
        add(AndroidLibraries.appCompat)
        add(AndroidLibraries.materialDesign)
        add(AndroidLibraries.coreKtx)
        add(AndroidLibraries.fragment)
        add(AndroidLibraries.navigation)
    }

    val lifecycle = arrayListOf<String>().apply {
        add(AndroidLibraries.lifecycleViewModel)
        add(AndroidLibraries.lifecycleRunTime)
    }

    val coroutines = arrayListOf<String>().apply {
        add(Libraries.coroutine)
        add(Libraries.coroutineCore)
    }


    val HiltLibraries = arrayListOf<String>().apply {
        add(Libraries.hilt)
        //add(Libraries.hiltLifecycle)
    }

    val HiltAnnotation = arrayListOf<String>().apply {
        add(Libraries.hiltCompiler)
    }

    val HiltLibraryKapt = arrayListOf<String>().apply {
        add(Libraries.hiltKapt)
    }


    val RetrofitLibraries = arrayListOf<String>().apply {
        add(Libraries.retrofit)
        add(Libraries.gson)
        add(Libraries.okhttpLogging)
    }


    val Glide = arrayListOf<String>().apply {
        add(Libraries.glide)
        add(Libraries.glideCompiler)
    }

}

fun DependencyHandler.kaptList(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.kaptTestList(list: List<String>) {
    list.forEach { dependency ->
        add("kaptTest", dependency)
    }
}


fun DependencyHandler.implementationList(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementationList(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementationList(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.runTimeOnlyList(list: List<String>) {
    list.forEach { dependency ->
        add("testRuntimeOnly", dependency)
    }
}

fun DependencyHandler.apiList(list: List<String>) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}