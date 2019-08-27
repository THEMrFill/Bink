package com.bink.philip.arnold.retrofit;

import com.bink.philip.arnold.model.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("categories.php")
    Call<Categories> getCategories();
}
