package com.bink.philip.arnold.ui.detail;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.MainActivityInterface;
import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.model.Meal;
import com.bink.philip.arnold.model.MealSingle;
import com.bink.philip.arnold.model.Meals;
import com.bink.philip.arnold.retrofit.RetrofitFactory;
import com.bink.philip.arnold.ui.main.MainFragmentInterface;
import com.bumptech.glide.Glide;

public class DetailFragment extends Fragment implements MainFragmentInterface {
    private String mealId;
    private MainActivityInterface mainActivityInterface;
    private ContentLoadingProgressBar progressBar;
    private RetrofitFactory retrofitFactory = new RetrofitFactory();

    private ImageView thumb;
    private TextView meal;
    private TextView category;
    private TextView area;
    private TextView instructions;
    private TextView tags;
    private TextView video;
    private TextView ingredients;
    private RecyclerView recycler;
    private DetailAdapter adapter = new DetailAdapter();

    DetailFragment(String mealId, MainActivityInterface mainActivityInterface) {
        this.mealId = mealId;
        this.mainActivityInterface = mainActivityInterface;
    }

    public static DetailFragment newInstance(String mealId, MainActivityInterface mainActivityInterface) {
        return new DetailFragment(mealId, mainActivityInterface);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        thumb = view.findViewById(R.id.thumb);
        meal = view.findViewById(R.id.meal);
        category = view.findViewById(R.id.category);
        area = view.findViewById(R.id.area);
        instructions = view.findViewById(R.id.instructions);
        tags = view.findViewById(R.id.tags);
        video = view.findViewById(R.id.video);
        ingredients = view.findViewById(R.id.ingredients);

        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData() {
        retrofitFactory.getMeal(mealId, this);
    }


    @Override
    public void returnCategories(Categories categories) {
    }

    @Override
    public void returnMeals(Meals meals) {
    }

    @Override
    public void returnMeal(MealSingle item) {
        if (item.getMeals().size() > 0) {
            final Meal thisMeal = item.getMeals().get(0);
            thisMeal.makeIngredients();

            mainActivityInterface.setTitle(thisMeal.strMeal, true);

            Glide.with(thumb)
                    .load(thisMeal.strMealThumb)
                    .into(thumb);

            textDisplayer(meal, thisMeal.strMeal);
            textDisplayer(category, "");
            textDisplayer(area, String.format("%s, %s", thisMeal.strArea, thisMeal.strCategory));
            textDisplayer(tags, thisMeal.strTags);
            textDisplayer(video, thisMeal.strYoutube);
            instructions.setText(formatInstructions(thisMeal.strInstructions));
            if (thisMeal.ingredients.size() > 0) {
                ingredients.setVisibility(View.VISIBLE);
                adapter.resetData(thisMeal.ingredients);
            }
        }
    }

    void textDisplayer(TextView view, String value) {
        if (value != null && value.length() > 0) {
            view.setText(value);
        } else {
            view.setVisibility(View.GONE);
        }
    }
    Spanned formatInstructions(String value) {
        if (value == null)
            return null;
        value = value.replace("\r\n\r\n", "\r\n");
        value = value.replace("\n", "<p>");
        return Html.fromHtml(value);
    }

    @Override
    public void returnError(Throwable t) {
        Toast.makeText(getContext(), "error: " + t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
