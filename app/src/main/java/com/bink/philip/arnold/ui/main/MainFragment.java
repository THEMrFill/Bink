package com.bink.philip.arnold.ui.main;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView recycler;
    private ContentLoadingProgressBar progressBar;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new MainAdapter(new Categories()));

        progressBar = view.findViewById(R.id.progressBar);

        return view;
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
        ((MainAdapter)recycler.getAdapter()).resetData(categories);
    }

    @Override
    public void returnError(Throwable t) {

    }
}
