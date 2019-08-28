package com.bink.philip.arnold.ui.main;

import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.model.MealSingle;
import com.bink.philip.arnold.model.Meals;

public interface MainFragmentInterface {
    void returnCategories(Categories categories);
    void returnMeals(Meals meals);
    void returnMeal(MealSingle meal);
    void returnError(Throwable t);
}
