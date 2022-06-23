package com.android.dobcalc.Utilities

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

fun ViewInteraction.waitUntilVisible(timeout: Long = 10000) {
    val startTime = System.currentTimeMillis()
    val endTime = startTime + timeout

    do {
        try {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            return
        } catch (t: Throwable) {
            Thread.sleep(50)
        }
    } while (System.currentTimeMillis() < endTime)
}

fun ViewInteraction.click() {
    waitUntilVisible()
    perform(ViewActions.click())
}

val ViewInteraction.text : String get() {
    waitUntilVisible()
    var text = String()
    perform(object: ViewAction {
        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(TextView::class.java)
        }

        override fun getDescription(): String {
            return "Text of the view"
        }

        override fun perform(uiController: UiController?, view: View?) {
            val tv = view as TextView
            text = tv.text.toString()
        }
    })
    return text
}