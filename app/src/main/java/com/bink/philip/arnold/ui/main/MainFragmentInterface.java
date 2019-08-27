package com.bink.philip.arnold.ui.main;

import com.bink.philip.arnold.model.Categories;

public interface MainFragmentInterface {
    void returnCategories(Categories categories);
    void returnError(Throwable t);
}
