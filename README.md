# Clean Architecture CRUD App Using Kotlin Multiplatform Mobile

First of all we need to add dependencies for both platform.
Dependencies are added on the `shared` module in the [`build.gradle.kts`](shared/build.gradle.kts) file.

## Adding dependencies

```kotlin
implementation("com.squareup.sqldelight:runtime:1.5.3")
implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
```

SQLDelight is write is pure kotlin and support KMM.

Also, we need to add the specific driver for each platform in:
- **androidMain** `implementation("com.squareup.sqldelight:android-driver:1.5.3")`
- **iosMain** `implementation("com.squareup.sqldelight:native-driver:1.5.3")`

And also add the plugin of SQLDelight. This allow generate corresponding entity classes at compile time in out project.

**`id("com.squareup.sqldelight")`**

```kotlin
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
}
```

Also, we change a little default config for [build.gradle.kts](./build.gradle.kts)

```kotlin
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
```

And also we need to add some dependencies on android side [build.gradle.kts](androidApp/build.gradle.kts).

```kotlin
plugins {
    ...
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    ...
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}

dependencies {
    ...
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}
```

:star: After that, you can run the Android and iOS emulator to check everything is working fine.