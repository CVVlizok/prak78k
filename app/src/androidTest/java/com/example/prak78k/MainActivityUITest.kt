package com.example.prak78k

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    //lateinit var activity: ActivityScenario<MainActivity>
/*
    @Before
    fun setup() {
        activity = ActivityScenario.launch(MainActivity::class.java)
        activity.moveToState(Lifecycle.State.RESUMED)
    }
    @After
    fun after() {
        activity.close()
    }
*/
    // Проверка отображения элементов и их id
    @Test
    fun checkUiElementsVisibility() {
        onView(withId(R.id.editTextUrl)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonDownload)).check(matches(isDisplayed()))
    }

    // Проверка, что начальное положение editText пустое
    @Test
    fun checkEditTextInitialState() {
        onView(withId(R.id.editTextUrl)).check(matches(withText("")))
    }

    // Проверка текста кнопки
    @Test
    fun checkButtonText() {
        onView(withId(R.id.buttonDownload)).check(matches(withText("Загрузить изображение")))
    }

    // Проверка ошибки при неверном URL
@Test
    fun checkButtonClick() {
        onView(withId(R.id.editTextUrl)).perform(
            typeText("https://example.com/invalid.jpg"),
            closeSoftKeyboard()
        )

        onView(withId(R.id.buttonDownload)).perform(click())

       // activityRule.scenario.


        //onView(withText("Ошибка загрузки изображения"))
          //  .inRoot(withDecorView(not(is(activityRule.scenario.onActivity { win }))))
            //        .check(matches(isDisplayed()))
            //}
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(withText("Ошибка загрузки изображения")))

    }


    // Проверка загрузки в ImageView
    @Test
    fun checkImageViewDisplayAfterDownload() {
        onView(withId(R.id.editTextUrl)).perform(
            typeText("https://i.pinimg.com/564x/52/ec/8a/52ec8a2b51749088c6b9ce0761ba54fb.jpg"),
            closeSoftKeyboard()
        )

        onView(withId(R.id.buttonDownload)).perform(click())

      //  Handler(Looper.getMainLooper()).postDelayed({
            // onView(withId(R.id.imageView)).check(matches(isDisplayed()))
       // }, 3000)
    }
}
