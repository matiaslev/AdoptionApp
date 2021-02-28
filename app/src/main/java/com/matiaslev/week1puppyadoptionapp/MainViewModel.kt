package com.matiaslev.week1puppyadoptionapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val puppiesList by lazy {
        listOf(
            Puppy(0, "Nina", "Morena, ladra mucho, hace caso, es miedosa"),
            Puppy(1, "Koki", "Blanca, chiquita, caniche!, dormilona y vaga, viejita!"),
            Puppy(2, "Dogui", "Energetico, guardian, caniche!, blanco.")
        )
    }

    val selectedPuppy = mutableStateOf(-1)

    fun getSelectedPuppy() = puppiesList[selectedPuppy.value]

}