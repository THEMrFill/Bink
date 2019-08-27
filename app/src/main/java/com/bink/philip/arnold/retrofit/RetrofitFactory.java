package com.bink.philip.arnold.retrofit;

import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.ui.main.MainFragmentInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public void getCategories(final MainFragmentInterface mainInterface) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        Call<Categories> call = service.getCategories();
        call.enqueue(new Callback<Categories>() {
            private Call<Categories> call;
            private Response<Categories> response;

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

}
