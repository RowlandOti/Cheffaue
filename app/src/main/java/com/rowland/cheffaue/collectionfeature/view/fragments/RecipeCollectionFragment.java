package com.rowland.cheffaue.collectionfeature.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.appfeature.ApplicationController;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeCollectionContract;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeSelectedContract;
import com.rowland.cheffaue.collectionfeature.presenter.RecipeCollectionPresenter;
import com.rowland.cheffaue.collectionfeature.view.activities.RecipeActivity;
import com.rowland.cheffaue.collectionfeature.view.adapters.RecipeCollectionAdapter;
import com.rowland.cheffaue.domain.model.RecipeModel;
import com.rowland.cheffaue.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RecipeCollectionFragment extends Fragment implements IRecipeCollectionContract.IRecipeCollectionView<RecipeModel> {

    public static final String SELECTED_RECIPE_KEY = "selected_recipe_key";

    @Inject
    RecipeCollectionPresenter mRecipeCollectionPresenter;

    @BindView(R.id.rc_collection)
    RecyclerView mCollectionRecyclerView;

    @BindView(R.id.rl_collection_loading)
    RelativeLayout mCollectionLoadingView;

    @BindView(R.id.rl_collection_retry)
    RelativeLayout mCollectionRetryView;


    private IRecipeSelectedContract.onClickListener mRecipeClickListener;
    private RecipeCollectionAdapter mRecipeCollectionAdapter;
    private Unbinder unbinder;

    public RecipeCollectionFragment() {
        // Required empty public constructor
    }

    public static RecipeCollectionFragment newInstance(Bundle args) {
        RecipeCollectionFragment fragment = new RecipeCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationController controller = ((ApplicationController) getActivity().getApplicationContext());
        controller.getRecipeCollectionComponent(this).inject(this);
        mRecipeCollectionPresenter.setRetrofit(controller.getRestComponent().retrofit());

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecipeCollectionAdapter = new RecipeCollectionAdapter();
        mCollectionRecyclerView.setAdapter(mRecipeCollectionAdapter);
        mCollectionRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), ScreenUtils.calculateNoOfColumns(getActivity(), RecipeActivity.mTwoPane)));
        mRecipeCollectionAdapter.setRecipeOnClickListener(new IRecipeSelectedContract.onClickListener() {
            @Override
            public void onItemClick(RecipeModel recipeModel) {
                if (mRecipeCollectionPresenter != null && recipeModel != null) {
                    mRecipeCollectionPresenter.viewRecipe(recipeModel);
                }
            }
        });

        this.loadRecipeCollection();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IRecipeSelectedContract.onClickListener) {
            mRecipeClickListener = (IRecipeSelectedContract.onClickListener) context;
        }
    }


    @Override
    public void renderRecipeCollection(Collection<RecipeModel> collection) {
        mRecipeCollectionAdapter.addAll(collection);
        Toast.makeText(getActivity(), String.valueOf(mRecipeCollectionAdapter.getItemCount()), Toast.LENGTH_LONG).show();
    }

    @Override
    public void viewRecipe(RecipeModel model) {
        if (mRecipeClickListener != null) {
            mRecipeClickListener.onItemClick(model);
        }
    }

    @Override
    public void loadRecipeCollection() {
        mRecipeCollectionPresenter.loadRecipeCollection();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void showLoading() {
        mCollectionLoadingView.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        mCollectionLoadingView.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        mCollectionRetryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        mCollectionRetryView.setVisibility(View.GONE);
    }

    @OnClick(R.id.tv_collection_retry)
    void onButtonRetryClick() {
        this.loadRecipeCollection();
    }


    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecipeCollectionPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mRecipeCollectionPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRecipeCollectionPresenter.destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
