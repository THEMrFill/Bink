package com.bink.philip.arnold.ui.meallist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.bink.philip.arnold.model.MealSingle;
import com.bink.philip.arnold.model.Meals;
import com.bink.philip.arnold.retrofit.RetrofitFactory;
import com.bink.philip.arnold.ui.main.MainAdapter;
import com.bink.philip.arnold.ui.main.MainFragmentInterface;

public class MealListFragment extends Fragment implements MainFragmentInterface {
    private String category;
    private MainActivityInterface mainActivityInterface;
    private RecyclerView recycler;
    private ContentLoadingProgressBar progressBar;
    private RetrofitFactory retrofitFactory = new RetrofitFactory();

    public MealListFragment(String category, MainActivityInterface mainActivityInterface) {
        this.category = category;
        this.mainActivityInterface = mainActivityInterface;
    }

    public static MealListFragment newInstance(String category, MainActivityInterface mainActivityInterface) {
        return new MealListFragment(category, mainActivityInterface);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new MealListAdapter(new Meals(), mainActivityInterface));

        progressBar = view.findViewById(R.id.progressBar);

        mainActivityInterface.setTitle(category);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData() {
        retrofitFactory.getMeals(category, this);
    }

    @Override
    public void returnCategories(Categories categories) {

    }

    @Override
    public void returnMeals(Meals meals) {
        progressBar.hide();
        ((MealListAdapter)recycler.getAdapter()).resetData(meals);
    }

    @Override
    public void returnMeal(MealSingle meal) {

    }

    @Override
    public void returnError(Throwable t) {
        Toast.makeText(getContext(), "error: " + t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
