package com.epicodus.bogglesoltaire;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

/**
 * Created by Guest on 11/16/16.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);
}
