package com.bink.philip.arnold.model;

import java.util.ArrayList;
import java.util.List;

public class MealSingle {
    private ArrayList<Meal> meals = new ArrayList<>();

    public List<Meal> getMeals() {
        return meals;
    }
    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
