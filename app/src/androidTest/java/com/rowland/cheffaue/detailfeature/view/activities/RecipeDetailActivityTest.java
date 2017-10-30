package com.rowland.cheffaue.detailfeature.view.activities;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.rowland.cheffaue.R;
import com.rowland.cheffaue.collectionfeature.view.fragments.RecipeCollectionFragment;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Rowland on 10/29/2017.
 */

public class RecipeDetailActivityTest extends ActivityInstrumentationTestCase2<RecipeDetailActivity> {

    public RecipeDetailActivityTest() {
        super(RecipeDetailActivity.class);
    }

    private static final String FAKE_RECIPE_ID = "Slow-Cooker-Tomato-Tortellini-Soup-2241239";

    private RecipeDetailActivity recipeDetailActivity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent callingIntent = new Intent(getInstrumentation().getTargetContext(), RecipeDetailActivity.class);
        callingIntent.putExtra(RecipeCollectionFragment.SELECTED_RECIPE_KEY, FAKE_RECIPE_ID);
        this.setActivityIntent(callingIntent);
        this.recipeDetailActivity = getActivity();
        Thread.sleep(3000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testContainsRecipeDetailsFragment() throws InterruptedException {
        Fragment recipeDetailFragment = recipeDetailActivity.getSupportFragmentManager().findFragmentById(R.id.fm_detail_section);
        assertThat(recipeDetailFragment, is(notNullValue()));
    }

    @Test
    public void testContainsProperRecipeDetailTitle() {
        String actualTitle = this.recipeDetailActivity.getTitle().toString().trim();
        assertThat(actualTitle, is("Cheffaue"));

        Toolbar toolbar = this.recipeDetailActivity.findViewById(R.id.toolbar);
        String actualToolbarTitle =  toolbar.getTitle().toString();

        assertThat(actualToolbarTitle, is("Slow Cooker Tomato Tortellini Soup"));
    }

    @Test
    public void testContainsRecipeDetailViews() throws InterruptedException {
        onView(withId(R.id.vp_detail_pager)).check(matches(isDisplayed()));
        onView(withId(R.id.sl_slidingtabstrips)).check(matches(isDisplayingAtLeast(10)));


        onView(allOf(childAtPosition(childAtPosition(withId(R.id.sl_slidingtabstrips), 0), 1))).perform(click());
        onView(withId(R.id.bcv_flavour)).check(matches(isDisplayed()));
        Thread.sleep(1000);

        onView(allOf(childAtPosition(childAtPosition(withId(R.id.sl_slidingtabstrips), 0), 2))).perform(click());
        onView(withId(R.id.rc_nutrition_collection)).check(matches(isDisplayingAtLeast(10)));
        onView(allOf(withId(R.id.tv_nutrient_attribute), withText("FAT_KCAL"), childAtPosition(childAtPosition(
                                        withId(R.id.rc_nutrition_collection), 0), 0), isDisplayed())).check(matches(withText("FAT_KCAL")));
        Thread.sleep(1000);

        onView(allOf(childAtPosition(childAtPosition(withId(R.id.sl_slidingtabstrips), 0), 0))).perform(click());
        onView(withId(R.id.rc_ingredient_collection)).check(matches(isDisplayingAtLeast(10)));
        onView(allOf(withId(R.id.tv_ingredient), withText("1 lb Italian sausage"), childAtPosition(childAtPosition(
                withId(R.id.rc_ingredient_collection), 0), 0), isDisplayed())).check(matches(withText("1 lb Italian sausage")));
        Thread.sleep(1000);
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
