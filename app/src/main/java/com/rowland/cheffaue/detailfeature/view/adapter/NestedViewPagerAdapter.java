/*
 * Copyright 2017 Oti Rowland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.rowland.cheffaue.detailfeature.view.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.rowland.cheffaue.detailfeature.view.fragments.child.FlavourFragment;
import com.rowland.cheffaue.detailfeature.view.fragments.child.IngredientFragment;
import com.rowland.cheffaue.detailfeature.view.fragments.child.NutritionFragment;
import com.rowland.cheffaue.domain.model.RecipeDetailModel;
import com.rowland.cheffaue.view.adapter.SmartFragmentStatePagerAdapter;

import java.util.ArrayList;


/**
 * Created by Rowland on 28/10/2017.
 */
public class NestedViewPagerAdapter extends SmartFragmentStatePagerAdapter {

    private String[] TITLES = {"Ingredients", "Flavour", "Nutrition"};

    private RecipeDetailModel mRecipeDetailModel;

    public NestedViewPagerAdapter(FragmentManager fm, RecipeDetailModel recipeDetailModel) {
        super(fm);
        this.mRecipeDetailModel = recipeDetailModel;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0: {
                Bundle args = new Bundle();
                args.putStringArrayList(IngredientFragment.INGREDIENT_COLLECTION, (ArrayList<String>) mRecipeDetailModel.getIngredientLines());

                return IngredientFragment.newInstance(args);
            }
            case 1: {
                Bundle args = new Bundle();
                args.putParcelable(FlavourFragment.FLAVOUR_ITEM, mRecipeDetailModel.getFlavors());

                return FlavourFragment.newInstance(args);
            }
            case 2: {
                Bundle args = new Bundle();
                args.putParcelableArrayList(NutritionFragment.NUTRITION_COLLECTION, (ArrayList<? extends Parcelable>) mRecipeDetailModel.getNutritionEstimates());

                return NutritionFragment.newInstance(args);
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return TITLES.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
