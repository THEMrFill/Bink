package com.bink.philip.arnold.ui.main;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bink.philip.arnold.MainActivityInterface;
import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.model.MealSingle;
import com.bink.philip.arnold.model.Meals;
import com.bink.philip.arnold.retrofit.RetrofitFactory;

public class MainFragment extends Fragment implements MainFragmentInterface {
    private MainViewModel mViewModel;
    private RecyclerView recycler;
    private ContentLoadingProgressBar progressBar;
    private MainActivityInterface mainActivityInterface;

    private RetrofitFactory retrofitFactory = new RetrofitFactory();

    public MainFragment(MainActivityInterface mainActivityInterface) {
        this.mainActivityInterface = mainActivityInterface;
    }

    public static MainFragment newInstance(MainActivityInterface mainActivityInterface) {
        return new MainFragment(mainActivityInterface);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new MainAdapter(new Categories(), mainActivityInterface));

        progressBar = view.findViewById(R.id.progressBar);

        mainActivityInterface.setTitle(getString(R.string.select_a_meal_category));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData() {
        progressBar.show();
        retrofitFactory.getCategories(this);
    }

    @Override
    public void returnCategories(Categories categories) {
        progressBar.hide();
        ((MainAdapter)recycler.getAdapter()).resetData(categories);
    }

    @Override
    public void returnMeals(Meals meals) {
    }

    @Override
    public void returnMeal(MealSingle meal) {
    }

    @Override
    public void returnError(Throwable t) {
        Toast.makeText(getContext(), "error: " + t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
