/**
 * An object that holds constants for testing dependencies.
 */
object Testing {
    private const val junitVersion = "4.13.2"
    /**
     * The JUnit 4 dependency.
     */
    const val junit4 = "junit:junit:$junitVersion"

    private const val junitAndroidExtVersion = "1.1.3"
    /**
     * The AndroidX Test JUnit extension dependency.
     */
    const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"

    private const val coroutinesTestVersion = "1.5.1"
    /**
     * The Kotlin Coroutines test dependency.
     */
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"

    private const val truthVersion = "1.1.3"
    /**
     * The Google Truth assertion library dependency.
     */
    const val truth = "com.google.truth:truth:$truthVersion"

    private const val mockkVersion = "1.10.0"
    /**
     * The MockK mocking library dependency.
     */
    const val mockk = "io.mockk:mockk:$mockkVersion"
    /**
     * The MockK Android mocking library dependency.
     */
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    private const val turbineVersion = "0.7.0"
    /**
     * The Turbine library for testing Kotlin Flows.
     */
    const val turbine = "app.cash.turbine:turbine:$turbineVersion"

    private const val mockWebServerVersion = "4.9.3"
    /**
     * The MockWebServer dependency for testing network requests.
     */
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"

    /**
     * The Jetpack Compose UI test dependency.
     */
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"

    /**
     * The Hilt Android testing dependency.
     */
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.version}"

    private const val testRunnerVersion = "1.4.0"
    /**
     * The AndroidX Test Runner dependency.
     */
    const val testRunner = "androidx.test:runner:$testRunnerVersion"
}