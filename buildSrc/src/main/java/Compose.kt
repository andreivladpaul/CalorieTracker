/**
 * An object that holds constants for Jetpack Compose dependencies.
 */
object Compose {
    /**
     * The version for core Jetpack Compose libraries.
     */
    const val composeVersion = "1.1.0-rc01"
    /**
     * The version for the Jetpack Compose compiler.
     */
    const val composeCompilerVersion = "1.1.0-rc02"
    /**
     * The Jetpack Compose Material dependency.
     */
    const val material = "androidx.compose.material:material:$composeVersion"
    /**
     * The Jetpack Compose UI dependency.
     */
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    /**
     * The Jetpack Compose UI Tooling Preview dependency.
     */
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    /**
     * The Jetpack Compose Runtime dependency.
     */
    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    /**
     * The Jetpack Compose Compiler dependency.
     */
    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"

    private const val navigationVersion = "2.4.0-beta02"
    /**
     * The Jetpack Compose Navigation dependency.
     */
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    /**
     * The Hilt Navigation Compose dependency.
     */
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.4.0"
    /**
     * The Activity Compose dependency.
     */
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    /**
     * The ViewModel Compose dependency from Lifecycle.
     */
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}
