package com.pajato.simplewebview

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.web.assertion.WebViewAssertions.webMatches
import android.support.test.espresso.web.model.Atoms.getCurrentUrl
import android.support.test.espresso.web.sugar.Web.onWebView
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class WebViewTest {
    @Rule @JvmField val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test fun testWebViewUrl() {
        onView(withId(R.id.uriText))
                .perform(replaceText("www.google.com"))
        onView(withId(R.id.submitButton))
                .perform(click())
        onWebView()
                .check<String>(webMatches<String>(getCurrentUrl(), containsString("google")))
    }
}