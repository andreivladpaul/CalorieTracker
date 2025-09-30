/**
 * An object that holds constants for build-related dependencies and plugins.
 */
object Build {
    private const val androidBuildToolsVersion = "7.0.4"
    /**
     * The Android Gradle Plugin dependency.
     */
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    /**
     * The Kotlin Gradle Plugin dependency.
     */
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    private const val hiltAndroidGradlePluginVersion = "2.38.1"
    /**
     * The Hilt Android Gradle Plugin dependency.
     */
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"
}