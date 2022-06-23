package com.android.dobcalc.Screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.android.dobcalc.R
import com.android.dobcalc.Utilities.click

class HomeScreen {

    companion object {
        const val APP_NAME = "Age In Minutes"
        const val CALENDAR_OK = "OK"
        const val CURRENT_YEAR = "2022"
    }

    val appName = onView(withText(APP_NAME))
    val appTitle = onView(withId(R.id.title))
    val selectDateBtn = onView(withId(R.id.selectDateBtn))
    val selectedDate = onView(withId(R.id.selectedStartDate))
    val dateDescription = onView(withId(R.id.selectedDateDescription))
    val age = onView(withId(R.id.ageInMinutes))
    val ageDescription = onView(withId(R.id.ageInMinsDescription))
    val calendarYear = onView(withText(CURRENT_YEAR))
    val okBtn = onView(withText(CALENDAR_OK))
    val day = onView(withText("15"))


    fun pickYear(year: String) {
        calendarYear.click()
        selectCalendarYear(year).click()
    }

    fun selectCalendarYear(year: String): ViewInteraction {
        return onView(withText(year))
    }
}