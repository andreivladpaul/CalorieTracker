package com.plcoding.calorytracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The main Application class for the Calory Tracker app.
 * This class is annotated with [@HiltAndroidApp] to enable field injection in
 * Android framework classes and to set up the Dagger Hilt component hierarchy.
 */
@HiltAndroidApp
class CaloryTrackerApp: Application()