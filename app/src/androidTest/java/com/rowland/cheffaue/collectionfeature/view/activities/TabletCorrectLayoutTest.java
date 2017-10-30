package com.rowland.cheffaue.collectionfeature.view.activities;

import android.support.test.rule.ActivityTestRule;

import com.rowland.cheffaue.R;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Created by Rowland on 7/23/2017.
 */

public class TabletCorrectLayoutTest extends ActivityTestRule<RecipeActivity> {


    RecipeActivity mActivity;

    public TabletCorrectLayoutTest() {
        super(RecipeActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        mActivity = getActivity();
        // other setup
    }

    @Test
    public void testDetailContainerIdExists() {
        assertTrue(mActivity.findViewById(R.id.fm_detail_section) != null);
        // other test
    }
}
