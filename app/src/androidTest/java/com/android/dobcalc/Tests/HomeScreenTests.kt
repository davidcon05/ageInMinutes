package com.android.dobcalc.Tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.android.dobcalc.MainActivity
import com.android.dobcalc.Screens.HomeScreen
import com.android.dobcalc.Utilities.click
import org.junit.Rule
import org.junit.Test

class HomeScreenTests : BaseTest() {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    val homeScreen = HomeScreen()


    companion object{
        const val YEAR = "2019"
    }

    @Test
    fun testAppNameAppears() {
        assertIsDisplayed(homeScreen.appName)
    }

    @Test
    fun testTitleAppears() {
        assertIsDisplayed(homeScreen.appTitle)
    }

    @Test
    fun testSelectDateBtnAppears() {
        assertIsDisplayed(homeScreen.selectDateBtn)
    }


    @Test
    fun testSelectDateButton() {
        // Select the date
        homeScreen.selectDateBtn.click()
        homeScreen.pickYear(YEAR)
        homeScreen.okBtn.click()
        // Verify date appears
        assertIsDisplayed(homeScreen.selectedDate)

        // Verify date description appears
        assertIsDisplayed(homeScreen.dateDescription)

        // Verify age in minutes appears
        assertIsDisplayed(homeScreen.age)

        // Verify age in minutes description appears
        assertIsDisplayed(homeScreen.ageDescription)
    }

}