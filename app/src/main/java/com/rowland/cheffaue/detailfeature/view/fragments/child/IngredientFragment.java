package com.rowland.cheffaue.detailfeature.view.fragments.child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rowland.cheffaue.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientFragment extends Fragment {

    public static final String INGREDIENT_COLLECTION = "ingredients_collection";

    @BindView(R.id.rc_ingredient_collection)
    RecyclerView mCollectionRecyclerView;

    private IngredientCollectionAdapter mIngredientCollectionAdapter;

    private Unbinder unbinder;


    public IngredientFragment() {
        // Required empty public constructor
    }

    public static IngredientFragment newInstance(Bundle args) {
        IngredientFragment fragment = new IngredientFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ingredient, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCollectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mIngredientCollectionAdapter = new IngredientCollectionAdapter();
        mCollectionRecyclerView.setAdapter(mIngredientCollectionAdapter);
        mCollectionRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        if (getArguments() != null) {
            Bundle args = getArguments();
            List<String> ingredientList = args.getStringArrayList(INGREDIENT_COLLECTION);
            mIngredientCollectionAdapter.addAll(ingredientList);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class IngredientCollectionAdapter extends RecyclerView.Adapter<IngredientCollectionAdapter.IngredientViewHolder> {

        private List<String> mCollection;

        public IngredientCollectionAdapter() {
            this.mCollection = new ArrayList<>();
        }

        @Override
        public IngredientCollectionAdapter.IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ingredient, parent, false);
            return new IngredientCollectionAdapter.IngredientViewHolder(itemView);
        }


        @Override
        public void onBindViewHolder(IngredientCollectionAdapter.IngredientViewHolder holder, int position) {
            holder.bindTo(this.mCollection.get(position));
        }

        @Override
        public int getItemCount() {
            return this.mCollection != null ? this.mCollection.size() : 0;
        }

        public void addAll(Collection<String> collection) {
            this.mCollection.addAll(collection);
            notifyDataSetChanged();
        }

        public void add(int position, String model) {
            mCollection.add(position, model);
            notifyItemInserted(position);
        }

        public void remove(String model) {
            int position = mCollection.indexOf(model);
            mCollection.remove(model);
            notifyItemRemoved(position);
        }

        public class IngredientViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_ingredient)
            TextView ingredientTextView;

            public IngredientViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public void bindTo(final String model) {
                ingredientTextView.setText(model);
            }
        }
    }
}
