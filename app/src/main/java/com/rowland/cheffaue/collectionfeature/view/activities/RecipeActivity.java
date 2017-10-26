package com.rowland.cheffaue.collectionfeature.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeSelectedContract;
import com.rowland.cheffaue.collectionfeature.view.fragments.RecipeCollectionFragment;
import com.rowland.cheffaue.detailfeature.view.activities.RecipeDetailActivity;
import com.rowland.cheffaue.detailfeature.view.fragments.RecipeDetailFragment;
import com.rowland.cheffaue.domain.model.RecipeModel;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeActivity extends AppCompatActivity implements IRecipeSelectedContract.onClickListener {

    public static boolean mTwoPane = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if (savedInstanceState == null) {
            showRecipeCollectionFragment(null);

            if (findViewById(R.id.fm_detail_section) != null) {
                mTwoPane = true;
            }
        }
    }

    private void showRecipeCollectionFragment(Bundle args) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        RecipeCollectionFragment collectionFragment = RecipeCollectionFragment.newInstance(args);
        ft.replace(R.id.fm_collection_section, collectionFragment);
        ft.commit();
    }

    private void showRecipeDetailFragment(Bundle args) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        RecipeDetailFragment detailFragment = RecipeDetailFragment.newInstance(args);
        ft.replace(R.id.fm_detail_section, detailFragment);
        ft.commit();
    }

    @Override
    public void onItemClick(RecipeModel model) {
        if (mTwoPane) {
            Bundle args = new Bundle();
            args.putString(RecipeCollectionFragment.SELECTED_RECIPE_KEY, model.getId());
            showRecipeDetailFragment(args);
        } else {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra(RecipeCollectionFragment.SELECTED_RECIPE_KEY, model.getId());
            startActivity(i);
        }

    }
}
