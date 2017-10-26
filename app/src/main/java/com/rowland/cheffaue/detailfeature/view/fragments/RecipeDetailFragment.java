package com.rowland.cheffaue.detailfeature.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.appfeature.ApplicationController;
import com.rowland.cheffaue.collectionfeature.presenter.RecipeCollectionPresenter;
import com.rowland.cheffaue.detailfeature.contracts.IRecipeDetailContract;
import com.rowland.cheffaue.detailfeature.presenter.RecipeDetailPresenter;
import com.rowland.cheffaue.domain.model.RecipeModel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailFragment extends Fragment implements IRecipeDetailContract.IRecipeDetailView<RecipeModel> {

    @Inject
    RecipeDetailPresenter mRecipeDetailPresenter;

    private Unbinder unbinder;

    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    public static RecipeDetailFragment newInstance(Bundle args) {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationController controller = ((ApplicationController) getActivity().getApplicationContext());
        controller.getRecipeDetailComponent(this).inject(this);
        mRecipeDetailPresenter.setRetrofit(controller.getRestComponent().retrofit());

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecipeDetailPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mRecipeDetailPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRecipeDetailPresenter.destroy();
        unbinder.unbind();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void loadRecipeDetail(RecipeModel recipeModel) {

    }

    @Override
    public void renderRecipeDetail(RecipeModel recipeModel) {

    }
}
