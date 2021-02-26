package com.matiaslev.week1puppyadoptionapp

import java.io.Serializable

data class Puppy(
    val name: String,
    val description: String
) : Serializable {
    companion object {
        fun getMockedList() = listOf(
            Puppy("Nina", "Morena, ladra mucho, hace caso, es miedosa"),
            Puppy("Koki", "Blanca, chiquita, caniche!, dormilona y vaga, viejita!"),
            Puppy("Dogui", "Energetico, guardian, caniche!, blanco.")
        )
    }
}
