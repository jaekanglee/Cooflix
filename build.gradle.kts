buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(GradleClasspath.androidGradlePlugin)
        classpath(GradleClasspath.kotlinGradlePluginClasspath)
        classpath(GradleClasspath.hiltGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        //classpath(GradleClasspath.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://naver.jfrog.io/artifactory/maven/")
        maven("https://jitpack.io")
        maven("https://devrepo.kakao.com/nexus/content/groups/public/")
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
