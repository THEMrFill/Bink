package com.bink.philip.arnold;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.bink.philip.arnold.ui.detail.DetailFragment;
import com.bink.philip.arnold.ui.main.MainFragment;
import com.bink.philip.arnold.ui.meallist.MealListFragment;

public class MainActivity extends AppCompatActivity implements MainActivityInterface{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            pushMainFragment();
        }
    }

    public void pushFragment(Fragment fragment, boolean addToStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        if (addToStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public void pushMainFragment() {
        pushFragment(MainFragment.newInstance(this), false);
    }

    @Override
    public void pushCategory(String category) {
        pushFragment(MealListFragment.newInstance(category, this), true);
    }

    @Override
    public void pushMeal(String mealId) {
        pushFragment(DetailFragment.newInstance(mealId, this), true);
    }

    @Override
    public void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}
