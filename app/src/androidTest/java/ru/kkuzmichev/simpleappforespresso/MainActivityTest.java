package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

public class MainActivityTest {
    private ViewInteraction mainText = onView(withId(R.id.text_home));
    private ViewInteraction appCompatImageButton = onView(withContentDescription("Open navigation drawer"));
    private ViewInteraction checkedTextHome = onView(withId(R.id.nav_home));
    private ViewInteraction checkedTextGallery = onView(withId(R.id.nav_gallery));
    private ViewInteraction checkedTextSlideshow = onView(withId(R.id.nav_slideshow));
    private ViewInteraction textView = onView(withId(R.id.text_slideshow));
    String HomeFragment = "This is home fragment";
    String SlideshowFragment = "This is slideshow fragment";

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        mainText.check(matches(isDisplayed()));
        mainText.check(matches(withText(HomeFragment)));
    }

    @Test
    public void visibilityCheckTest() {
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());
        checkedTextHome.check(matches(isDisplayed()));
        checkedTextGallery.check(matches(isDisplayed()));
        checkedTextSlideshow.check(matches(isDisplayed()));
    }

    @Test
    public void textDisplayTest() {
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());
        checkedTextSlideshow.check(matches(isDisplayed()));
        checkedTextSlideshow.perform(click());
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText(SlideshowFragment)));
    }
}
