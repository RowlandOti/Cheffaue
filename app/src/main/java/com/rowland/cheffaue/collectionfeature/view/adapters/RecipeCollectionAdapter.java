package com.rowland.cheffaue.collectionfeature.view.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.collectionfeature.contracts.IRecipeSelectedContract;
import com.rowland.cheffaue.domain.model.RecipeModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rowland on 10/25/2017.
 */

/**
 * Adaptar that manages a collection of {@link RecipeModel}.
 */
public class RecipeCollectionAdapter extends RecyclerView.Adapter<RecipeCollectionAdapter.RecipeViewHolder> {

    private List<RecipeModel> mCollection;
    private IRecipeSelectedContract.onClickListener mRecipeOnClickListener;

    public RecipeCollectionAdapter() {
        this.mCollection = new ArrayList<>();
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recipe, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.bindTo(this.mCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mCollection != null ? this.mCollection.size() : 0;
    }

    public void addAll(Collection<RecipeModel> collection) {
        this.mCollection.addAll(collection);
        notifyDataSetChanged();
    }

    public void add(int position, RecipeModel model) {
        mCollection.add(position, model);
        notifyItemInserted(position);
    }

    public void remove(RecipeModel model) {
        int position = mCollection.indexOf(model);
        mCollection.remove(model);
        notifyItemRemoved(position);
    }

    public void setRecipeOnClickListener (IRecipeSelectedContract.onClickListener recipeOnClickListener) {
        this.mRecipeOnClickListener = recipeOnClickListener;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_recipe_image)
        ImageView recipeImageView;

        @BindView(R.id.rl_recipe_title_container)
        RelativeLayout recipeRecipeNameContainer;

        @BindView(R.id.tv_recipe_name)
        TextView recipeNameTextView;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(final RecipeModel recipeModel) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mRecipeOnClickListener != null) {
                        mRecipeOnClickListener.onItemClick(recipeModel);
                    }
                }
            });
            recipeNameTextView.setText(recipeModel.getRecipeName());

            String imageUrl = recipeModel.getSmallImageUrls().get(0);
            imageUrl = imageUrl.replaceAll("s90", "s400");

            Picasso.with(recipeImageView.getContext())
                    .load(imageUrl)
                    .into(recipeImageView);
        }
    }
}
