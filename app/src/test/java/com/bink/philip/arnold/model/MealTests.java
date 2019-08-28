package com.bink.philip.arnold.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MealTests {
    @Test
    public void checkEmptyIngredients() {
        Meal meal = new Meal();
        meal.makeIngredients();

        assertEquals(meal.ingredients.size(), 0);
    }

    @Test
    public void checkSingleIngredients() {
        Meal meal = new Meal();
        meal.strIngredient1 = "test1";
        meal.strMeasure1 = "test2";
        meal.makeIngredients();

        assertEquals(meal.ingredients.size(), 1);

        // also check that the contents of the ingredients entry is right
        Ingredient ingredient = new Ingredient("test1", "test2");
        assertEquals(meal.ingredients.get(0).toString(), ingredient.toString());
    }
    @Test
    public void checkMultipleIngredients() {
        Meal meal = new Meal();
        meal.strIngredient1 = "test1";  meal.strMeasure1 = "test2";
        meal.strIngredient2 = "test3";  meal.strMeasure2 = "test4";
        meal.strIngredient3 = "test5";  meal.strMeasure3 = "test6";
        meal.strIngredient4 = "test7";  meal.strMeasure4 = "test8";
        meal.strIngredient5 = "test9";  meal.strMeasure5 = "test10";
        meal.makeIngredients();

        assertEquals(meal.ingredients.size(), 5);
    }
}
