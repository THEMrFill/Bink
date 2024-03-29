package com.bink.philip.arnold.model;

public class Ingredient {
    public Ingredient(String ingredient, String measure) {
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public String ingredient;
    public String measure;

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient='" + ingredient + '\'' +
                ", measure='" + measure + '\'' +
                '}';
    }
}
