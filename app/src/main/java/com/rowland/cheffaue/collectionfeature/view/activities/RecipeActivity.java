package com.rowland.cheffaue.collectionfeature.view.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.collectionfeature.view.fragments.RecipeCollectionFragment;

/**
 * Created by Rowland on 10/24/2017.
 */

public class RecipeActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if(savedInstanceState == null) {
            showRecipeCollectionFragment(null);
        }
    }

    private void showRecipeCollectionFragment(Bundle args) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        RecipeCollectionFragment detailFragment = RecipeCollectionFragment.newInstance(args);
        ft.replace(R.id.fm_list_section, detailFragment);
        ft.commit();
    }
}
