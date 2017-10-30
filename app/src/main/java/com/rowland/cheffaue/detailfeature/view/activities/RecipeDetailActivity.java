package com.rowland.cheffaue.detailfeature.view.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.collectionfeature.view.fragments.RecipeCollectionFragment;
import com.rowland.cheffaue.detailfeature.view.fragments.RecipeDetailFragment;
import com.rowland.cheffaue.view.activities.ABaseToolBarActivity;

public class RecipeDetailActivity extends ABaseToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle args = new Bundle();
        args.putString(RecipeCollectionFragment.SELECTED_RECIPE_KEY, intent.getStringExtra(RecipeCollectionFragment.SELECTED_RECIPE_KEY));

        //if(savedInstanceState == null) {
            showRecipeDetailFragment(args);
        //}
    }

    private void showRecipeDetailFragment(Bundle args) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        RecipeDetailFragment detailFragment = RecipeDetailFragment.newInstance(args);
        ft.replace(R.id.fm_detail_section, detailFragment);
        ft.commit();
    }
}
