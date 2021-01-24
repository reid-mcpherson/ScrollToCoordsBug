package com.example.scrollview

import android.graphics.Point
import android.widget.FrameLayout
import android.widget.ScrollView
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun scrollToCoordinates_unexpectedResult(){
        val activityController = Robolectric.buildActivity(MainActivity::class.java)
        val activity = activityController.get()
        activityController.setup()

        val scrollView = activity.findViewById<ScrollView>(R.id.scrollView)
        scrollView.scrollTo(0, 250)

        val shadow = Shadows.shadowOf(scrollView)
        assertThat(shadow.scrollToCoordinates).isEqualTo(Point(0, 250))
    }

    @Test
    fun scrollToCoordinates_expectedResult(){
        val activityController = Robolectric.buildActivity(MainActivity::class.java)
        val activity = activityController.get()
        activityController.setup()

        val outerFrame = activity.findViewById<FrameLayout>(R.id.outerFrame)
        outerFrame.scrollTo(0, 250)

        val shadow = Shadows.shadowOf(outerFrame)
        assertThat(shadow.scrollToCoordinates).isEqualTo(Point(0, 250))
    }
}