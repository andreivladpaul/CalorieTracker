/**
 * An object that holds constants for the project's Gradle modules.
 */
object Modules {
    /**
     * The main application module.
     */
    const val app = ":app"

    /**
     * The core module, containing shared business logic.
     */
    const val core = ":core"
    /**
     * The core-ui module, containing shared UI components.
     */
    const val coreUi = ":core-ui"

    /**
     * The domain layer for the onboarding feature.
     */
    const val onboardingDomain = ":onboarding:onboarding_domain"
    /**
     * The presentation layer for the onboarding feature.
     */
    const val onboardingPresentation = ":onboarding:onboarding_presentation"

    /**
     * The data layer for the tracker feature.
     */
    const val trackerData = ":tracker:tracker_data"
    /**
     * The domain layer for the tracker feature.
     */
    const val trackerDomain = ":tracker:tracker_domain"
    /**
     * The presentation layer for the tracker feature.
     */
    const val trackerPresentation = ":tracker:tracker_presentation"
}