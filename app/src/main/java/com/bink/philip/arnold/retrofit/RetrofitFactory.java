package com.bink.philip.arnold.retrofit;

import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.model.MealSingle;
import com.bink.philip.arnold.model.Meals;
import com.bink.philip.arnold.ui.main.MainFragmentInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RetrofitFactory {
    private final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private Gson gson = new GsonBuilder().setLenient().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    private RetrofitService service = retrofit.create(RetrofitService.class);

    public void getCategories(final MainFragmentInterface mainInterface) {
        Call<Categories> call = service.getCategories();
        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if (response.isSuccessful()) {
                    mainInterface.returnCategories(response.body());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                mainInterface.returnError(t);
            }
        });
    }

    public void getMeals(String category, final MainFragmentInterface mainInterface) {
        Call<Meals> call = service.getMeals(category);
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                mainInterface.returnMeals(response.body());
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                mainInterface.returnError(t);
            }
        });
    }

    public void getMeal(String mealId, final MainFragmentInterface mainInterface) {
        Call<MealSingle> call = service.getMeal(mealId);
        call.enqueue(new Callback<MealSingle>() {
            @Override
            public void onResponse(Call<MealSingle> call, Response<MealSingle> response) {
                mainInterface.returnMeal(response.body());
            }

            @Override
            public void onFailure(Call<MealSingle> call, Throwable t) {
                mainInterface.returnError(t);
            }
        });
    }
}
