# ScrollToCoordsBug
Tests demonstrating ScrollView scrollToCoordinates bug in Robolectric 4.3.1

```
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
```

```
Expected :Point(0, 250)
Actual   :Point(0, 0)
```
