package com.bink.philip.arnold.ui.detail;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.MainActivityInterface;
import com.bink.philip.arnold.retrofit.RetrofitFactory;
import com.bink.philip.arnold.ui.meallist.MealListFragment;

public class DetailFragment extends Fragment {
    private String mealId;
    private MainActivityInterface mainActivityInterface;
    private RecyclerView recycler;
    private ContentLoadingProgressBar progressBar;
    private RetrofitFactory retrofitFactory = new RetrofitFactory();

    public DetailFragment(String category, MainActivityInterface mainActivityInterface) {
        this.mealId = mealId;
        this.mainActivityInterface = mainActivityInterface;
    }

    public static DetailFragment newInstance(String mealId, MainActivityInterface mainActivityInterface) {
        return new DetailFragment(mealId, mainActivityInterface);
    }


}
