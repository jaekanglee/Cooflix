// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(GradlePlugin.ANDROID_APPLICATION) version "7.2.1" apply false
    id(GradlePlugin.ANDROID_LIBRARY) version "7.2.1" apply false
    id(GradlePlugin.KOTLIN_ANDROID) version "1.6.10" apply false
}

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}

allprojects {

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
