package com.bink.philip.arnold.retrofit;

import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.model.MealSingle;
import com.bink.philip.arnold.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php?")
    Call<Meals> getMeals(@Query("c") String category);

    @GET("lookup.php?")
    Call<MealSingle> getMeal(@Query("i") String mealId);
}
