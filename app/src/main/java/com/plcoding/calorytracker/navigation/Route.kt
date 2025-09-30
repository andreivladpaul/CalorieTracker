package com.plcoding.calorytracker.navigation

/**
 * A utility object that holds the navigation routes for the application.
 * These routes are used by the Jetpack Compose Navigation component to identify screens.
 */
object Route {
    // Onboarding routes
    const val WELCOME = "welcome"
    const val AGE = "age"
    const val GENDER = "gender"
    const val HEIGHT = "height"
    const val WEIGHT = "weight"
    const val NUTRIENT_GOAL = "nutrient_goal"
    const val ACTIVITY = "activity"
    const val GOAL = "goal"

    // Tracker routes
    const val TRACKER_OVERVIEW = "tracker_overview"
    const val SEARCH = "search"
}