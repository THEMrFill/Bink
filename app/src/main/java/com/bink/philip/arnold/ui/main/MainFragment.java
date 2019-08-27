package com.bink.philip.arnold.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Categories;
import com.bink.philip.arnold.retrofit.RetrofitFactory;

public class MainFragment extends Fragment implements MainFragmentInterface {
    private String TAG = getClass().getSimpleName();
    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new RetrofitFactory().getCategories(this);
    }

    @Override
    public void returnCategories(Categories categories) {
        Log.d(TAG, "categories=" + categories.categories.toString());
    }

    @Override
    public void returnError(Throwable t) {

    }
}
