package com.bink.philip.arnold;

public interface MainActivityInterface {
    void pushCategory(String category);
    void pushMeal(String mealId);
    void setTitle(String title);
    void setTitle(String title, boolean canGoBack);
}
