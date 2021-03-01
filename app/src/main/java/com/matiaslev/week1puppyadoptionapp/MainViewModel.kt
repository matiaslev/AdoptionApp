package com.matiaslev.week1puppyadoptionapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val puppiesList by lazy {
        listOf(
            Puppy(
                id = 0,
                name = "Nina",
                description = "Morena, ladra mucho, hace caso, es miedosa",
                image = listOf(R.drawable.ovejero_1, R.drawable.ovejero_2, R.drawable.ovejero_3)
            ),
            Puppy(
                id = 1,
                name = "Koki",
                description = "Blanca, chiquita, caniche!, dormilona y vaga, viejita!",
                image = listOf(R.drawable.ovejero_1, R.drawable.ovejero_2, R.drawable.ovejero_3)
            ),
            Puppy(
                id = 2,
                name = "Dogui",
                description = "Energetico, guardian, caniche!, blanco.",
                image = listOf(R.drawable.ovejero_1, R.drawable.ovejero_2, R.drawable.ovejero_3)
            )
        )
    }

    val selectedPuppy = mutableStateOf(-1)

    fun getSelectedPuppy() = puppiesList[selectedPuppy.value]

}