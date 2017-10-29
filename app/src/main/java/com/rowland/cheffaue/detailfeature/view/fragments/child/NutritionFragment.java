package com.rowland.cheffaue.detailfeature.view.fragments.child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.domain.payload.NutritionEstimate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NutritionFragment extends Fragment {

    public static final String NUTRITION_COLLECTION = "nutrition_collection";

    @BindView(R.id.rc_nutrition_collection)
    RecyclerView mCollectionRecyclerView;

    private NutritionCollectionAdapter mNutritionCollectionAdapter;


    public NutritionFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;


    public static NutritionFragment newInstance(Bundle args) {
        NutritionFragment fragment = new NutritionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nutrition, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCollectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNutritionCollectionAdapter = new NutritionCollectionAdapter();
        mCollectionRecyclerView.setAdapter(mNutritionCollectionAdapter);
        mCollectionRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        if (getArguments() != null) {
            Bundle args = getArguments();
            List<NutritionEstimate> NutritionList = args.getParcelableArrayList(NUTRITION_COLLECTION);
            mNutritionCollectionAdapter.addAll(NutritionList);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class NutritionCollectionAdapter extends RecyclerView.Adapter<NutritionCollectionAdapter.NutritionViewHolder> {

        private List<NutritionEstimate> mCollection;

        public NutritionCollectionAdapter() {
            this.mCollection = new ArrayList<>();
        }

        @Override
        public NutritionCollectionAdapter.NutritionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_nutrition, parent, false);
            return new NutritionCollectionAdapter.NutritionViewHolder(itemView);
        }


        @Override
        public void onBindViewHolder(NutritionCollectionAdapter.NutritionViewHolder holder, int position) {
            holder.bindTo(this.mCollection.get(position));
        }

        @Override
        public int getItemCount() {
            return this.mCollection != null ? this.mCollection.size() : 0;
        }

        public void addAll(Collection<NutritionEstimate> collection) {
            this.mCollection.addAll(collection);
            notifyDataSetChanged();
        }

        public void add(int position, NutritionEstimate model) {
            mCollection.add(position, model);
            notifyItemInserted(position);
        }

        public void remove(NutritionEstimate model) {
            int position = mCollection.indexOf(model);
            mCollection.remove(model);
            notifyItemRemoved(position);
        }

        public class NutritionViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_nutrient_attribute)
            TextView nutritionAttributeTextView;

            @BindView(R.id.tv_nutrient_description)
            TextView nutritionDescriptionTextView;

            @BindView(R.id.tv_nutrient_value)
            TextView nutritionValueTextView;


            public NutritionViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public void bindTo(final NutritionEstimate model) {
                nutritionAttributeTextView.setText(model.getAttribute());
                // Quick patch for missing description for FAT_KCAL
                nutritionDescriptionTextView.setText(model.getAttribute().equals("FAT_KCAL") ? "Fatty Calories" :  model.getDescription());
                nutritionValueTextView.setText(String.format("%f %s", model.getValue(), model.getUnit().getPlural()));
            }
        }
    }

}
