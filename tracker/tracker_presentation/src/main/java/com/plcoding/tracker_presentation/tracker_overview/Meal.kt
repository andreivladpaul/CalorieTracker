package com.plcoding.tracker_presentation.tracker_overview

import androidx.annotation.DrawableRes
import com.plcoding.core.util.UiText
import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_presentation.R

/**
 * Represents a meal in the tracker overview UI.
 * This class holds the displayable information for a meal, such as its name, icon,
 * and nutrient totals, as well as its UI state (expanded or collapsed).
 *
 * @property name The name of the meal (e.g., "Breakfast").
 * @property drawableRes The drawable resource ID for the meal's icon.
 * @property mealType The type of the meal from the domain layer.
 * @property carbs The total carbohydrates for the meal in grams.
 * @property protein The total protein for the meal in grams.
 * @property fat The total fat for the meal in grams.
 * @property calories The total calories for the meal.
 * @property isExpanded Whether the meal is currently expanded in the UI to show its tracked foods.
 */
data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
)

/**
 * A default list of meals to be displayed on the tracker overview screen.
 */
val defaultMeals = listOf(
    Meal(
        name = UiText.StringResource(R.string.breakfast),
        drawableRes = R.drawable.ic_breakfast,
        mealType = MealType.Breakfast
    ),
    Meal(
        name = UiText.StringResource(R.string.lunch),
        drawableRes = R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.StringResource(R.string.dinner),
        drawableRes = R.drawable.ic_dinner,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UiText.StringResource(R.string.snacks),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.Snack
    ),
)
