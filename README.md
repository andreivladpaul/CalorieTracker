# Calory Tracker

Calory Tracker is a multi-module Android application built with Jetpack Compose that helps users track their daily food intake and monitor their nutritional goals.

## Features

*   **Onboarding:** A guided flow for new users to set up their profile, including gender, age, height, weight, activity level, and dietary goals.
*   **Daily Tracker:** An overview screen that displays the user's daily calorie and macronutrient consumption against their goals.
*   **Food Search:** Users can search for food items using the Open Food Facts API.
*   **Meal Tracking:** Users can add tracked food items to different meals (Breakfast, Lunch, Dinner, Snacks).
*   **Dynamic Theming:** Supports both light and dark themes based on the system settings.

## Project Structure

The project is structured into several Gradle modules to promote separation of concerns and scalability:

*   `app`: The main application module that integrates all other modules and handles navigation.
*   `core`: Contains shared business logic, domain models, and utility classes used across multiple features.
*   `core-ui`: Holds shared Jetpack Compose UI components, such as colors, dimensions, and custom composables.
*   `onboarding`: A feature module that contains the entire onboarding flow, separated into `onboarding_domain` and `onboarding_presentation`.
*   `tracker`: A feature module for the core food tracking functionality, separated into `tracker_data`, `tracker_domain`, and `tracker_presentation`.

## Setup

To build and run the project, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
2.  **Open in Android Studio:**
    Open the cloned project in Android Studio (Bumblebee | 2021.1.1 or newer is recommended).
3.  **Sync Gradle:**
    Android Studio will automatically sync the Gradle files and download the necessary dependencies.
4.  **Run the application:**
    Select the `app` configuration and run it on an emulator or a physical device.

## Usage

1.  **Onboarding:** On the first launch, you will be guided through an onboarding process to set up your personal and dietary information.
2.  **Tracker Overview:** After onboarding, you will see the main tracker screen, which shows your daily progress.
3.  **Add Food:** Tap the "Add" button for any meal to search for and track a food item.
4.  **Navigate Days:** Use the arrows at the top of the tracker screen to view your history for previous or future dates.