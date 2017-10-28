package com.rowland.cheffaue.detailfeature.view.fragments.child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.domain.payload.Flavour;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlavourFragment extends Fragment {

    public static final String FLAVOUR_ITEM = "Flavour_item";

    @BindView(R.id.tv_flavour)
    TextView mFlavourTextView;

    public FlavourFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;


    public static FlavourFragment newInstance(Bundle args) {
        FlavourFragment fragment = new FlavourFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flavour, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            Bundle args = getArguments();
            Flavour flavour = args.getParcelable(FLAVOUR_ITEM);
            mFlavourTextView.setText(String.valueOf(flavour.getBitter()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

