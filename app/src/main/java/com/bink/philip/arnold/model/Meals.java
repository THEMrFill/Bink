package com.bink.philip.arnold.model;

import java.util.ArrayList;

public class Meals {
    public ArrayList<MealItem> meals = new ArrayList<>();

    public ArrayList<MealItem> getMeals() {
        return meals;
    }
    public void setMeals(ArrayList<MealItem> meals) {
        this.meals = meals;
    }
}
