package com.rowland.cheffaue.collectionfeature.view.activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.rowland.cheffaue.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PhoneRecipeActivityTest {

    @Rule
    public ActivityTestRule<RecipeActivity> mActivityTestRule = new ActivityTestRule<>(RecipeActivity.class);

    @Test
    public void recipeActivityTest() throws InterruptedException {

        Thread.sleep(3000);
        ViewInteraction recyclerView = onView(allOf(withId(R.id.rc_collection),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.fm_collection_section),
                                0),
                        0),
                isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(6, click()));

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.rc_collection),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fm_collection_section),
                                        0),
                                0),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(1000);
        ViewInteraction textView = onView(
                allOf(withId(R.id.tv_ingredient), withText("2 tablespoons butter"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rc_ingredient_collection),
                                        0),
                                0),
                        isDisplayed()));
        Thread.sleep(1000);
        textView.check(matches(withText("2 tablespoons butter")));

        ViewInteraction tabView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.sl_slidingtabstrips),
                                0),
                        2),
                        isDisplayed()));
        tabView.perform(click());

        Thread.sleep(1000);
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tv_nutrient_attribute), withText("FAT_KCAL"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rc_nutrition_collection),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("FAT_KCAL")));

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
