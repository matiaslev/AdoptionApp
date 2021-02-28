package com.matiaslev.week1puppyadoptionapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ListScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun add_puppy_initially_hidden() {
        composeTestRule.onNodeWithText("Add Puppy").assertDoesNotExist()
    }

    @Test
    fun add_puppy_displayed() {
        composeTestRule.onNodeWithContentDescription("Add").performClick()

        composeTestRule.onNodeWithText("Add Puppy").assertExists()
    }
}