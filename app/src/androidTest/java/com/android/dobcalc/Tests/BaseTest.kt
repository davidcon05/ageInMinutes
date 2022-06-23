package com.android.dobcalc.Tests

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.CoreMatchers.not

open class BaseTest {

    fun assertIsDisplayed(interaction: ViewInteraction) {
        interaction.check(matches(isDisplayed()))
    }

    fun assertNotDisplayed(interaction: ViewInteraction) {
        interaction.check(matches(not(isDisplayed())))
    }
}