package com.matiaslev.week1puppyadoptionapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val puppiesList by lazy {
        listOf(
            Puppy(
                id = 0,
                name = "Bonnie and Clyde",
                description = "Hello, we are two little kittens looking for a home!",
                image = listOf(R.drawable.bonnie)
            ),
            Puppy(
                id = 1,
                name = "Nina",
                description = "She is an adult dog, very cuddly and companion, she likes to spend the afternoons playing and is an excellent companion.\n" +
                    "She gets along very well with children, and she is looking for a forever family where to spend her days.",
                image = listOf(R.drawable.nina_1, R.drawable.nina_2, R.drawable.nina_3)
            ),
            Puppy(
                id = 2,
                name = "India",
                description = "I am India, a one year old kitten, I am neutered, I am very naughty, I like to go for a walk and I get along well with all animals and I would like to find a family.",
                image = listOf(R.drawable.india_1, R.drawable.india_2)
            ),
            Puppy(
                id = 3,
                name = "Dogui",
                description = "Dogui is a funny little puppy with crazy curlers who loves to play in the water. He would love to be part of your family forever!",
                image = listOf(R.drawable.dogui_1, R.drawable.dogui_2)
            )
        )
    }

    val selectedPuppy = mutableStateOf(-1)

    fun getSelectedPuppy() = puppiesList[selectedPuppy.value]

}