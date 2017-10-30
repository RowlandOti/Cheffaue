package com.rowland.cheffaue.detailfeature.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.appfeature.ApplicationController;
import com.rowland.cheffaue.collectionfeature.view.fragments.RecipeCollectionFragment;
import com.rowland.cheffaue.detailfeature.contracts.IRecipeDetailContract;
import com.rowland.cheffaue.detailfeature.presenter.RecipeDetailPresenter;
import com.rowland.cheffaue.detailfeature.view.activities.RecipeDetailActivity;
import com.rowland.cheffaue.detailfeature.view.adapter.NestedViewPagerAdapter;
import com.rowland.cheffaue.domain.model.RecipeDetailModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailFragment extends Fragment implements IRecipeDetailContract.IRecipeDetailView<RecipeDetailModel> {

    @Inject
    RecipeDetailPresenter mRecipeDetailPresenter;

    @BindView(R.id.img_recipe_detail_backdrop)
    ImageView mDetailImageView;
    @BindView(R.id.tv_detail_recipename)
    TextView recipeNameTextView;
    @BindView(R.id.tv_detail_noservings)
    TextView servingsTextView;
    @BindView(R.id.tv_detail_totalpreptime)
    TextView prepTimeTextView;
    @BindView(R.id.tv_detail_rating)
    TextView ratingsTextView;

    @BindView(R.id.recipe_detail_appbar)
    AppBarLayout mDetailAppbarLayout;
    @BindView(R.id.vp_detail_pager)
    ViewPager mDetailViewPager;
    @BindView(R.id.sl_slidingtabstrips)
    TabLayout mSlidingTabStrips;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private NestedViewPagerAdapter detailViewPagerAdapter;
    private Unbinder unbinder;
    private String recipeId;

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
            Bundle args = getArguments();
            recipeId = args.getString(RecipeCollectionFragment.SELECTED_RECIPE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSlidingTabStrips.setupWithViewPager(mDetailViewPager);

        if (recipeId != null) {
            this.loadRecipeDetail(recipeId);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Check which instance we are dealing with
        if (getActivity() instanceof RecipeDetailActivity) {
            ((RecipeDetailActivity) getActivity()).setToolbar(mToolbar, true, false, 0);
            ((RecipeDetailActivity) getActivity()).setToolbarTransparent(true);
        }
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
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadRecipeDetail(String recipeModelId) {
        mRecipeDetailPresenter.loadRecipeDetail(recipeModelId);
    }

    @Override
    public void renderRecipeDetail(final RecipeDetailModel recipeDetailModel) {
        String hostedImageUrl = recipeDetailModel.getImages().get(0).getHostedLargeUrl();
        hostedImageUrl = hostedImageUrl.replaceAll("s90", "s500");
        Picasso.with(getActivity()).load(hostedImageUrl).into(mDetailImageView);

        recipeNameTextView.setText(" ");
        ratingsTextView.setText(String.format("Rating: %d/10", Math.round(recipeDetailModel.getRating())));
        servingsTextView.setText(String.format("Servings: %d", Math.round(recipeDetailModel.getNumberOfServings())));
        prepTimeTextView.setText(String.format("Prep Time: %s", recipeDetailModel.getTotalTime()));

        detailViewPagerAdapter = new NestedViewPagerAdapter(getChildFragmentManager(), recipeDetailModel);
        mDetailViewPager.setAdapter(detailViewPagerAdapter);

        if (getActivity() instanceof RecipeDetailActivity) {
            mToolbar.setTitle(recipeDetailModel.getName());
        }
        else {
            getActivity().setTitle(recipeDetailModel.getName());
        }
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
