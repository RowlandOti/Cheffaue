package com.rowland.cheffaue.detailfeature.view.fragments.child;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.db.chart.animation.Animation;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.renderer.XRenderer;
import com.db.chart.renderer.YRenderer;
import com.db.chart.view.BarChartView;
import com.db.chart.view.HorizontalBarChartView;
import com.rowland.cheffaue.R;
import com.rowland.cheffaue.domain.payload.Flavour;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlavourFragment extends Fragment {

    public static final String FLAVOUR_ITEM = "flavour_item";

    @BindView(R.id.bcv_flavour)
    HorizontalBarChartView mBarChartView;

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

            String[] mLabels = {"Piquant", "Meaty", "Bitter", "Sweet", "Sour", "Salty"};
            float piqValue = Float.parseFloat(String.valueOf(flavour.getPiquant()));
            float meatValue = Float.parseFloat(String.valueOf(flavour.getMeaty()));
            float bitValue = Float.parseFloat(String.valueOf(flavour.getBitter()));
            float sweValue = Float.parseFloat(String.valueOf(flavour.getSweet()));
            float souValue = Float.parseFloat(String.valueOf(flavour.getSour()));
            float salValue = Float.parseFloat(String.valueOf(flavour.getSalty()));
            float[] mValues = {piqValue, meatValue, bitValue, sweValue, souValue, salValue};

            // Data
            BarSet barSet = new BarSet(mLabels, mValues);
            barSet.setColor(Color.parseColor("#FF4081"));
            mBarChartView.addData(barSet);
            mBarChartView.setAxisBorderValues(0,1);
            mBarChartView
                    .setXLabels(XRenderer.LabelPosition.OUTSIDE)
                    .setYLabels(YRenderer.LabelPosition.OUTSIDE)
                    .show(new Animation().inSequence(.5f, new int[]{1, 0, 5, 3, 4, 2}));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

