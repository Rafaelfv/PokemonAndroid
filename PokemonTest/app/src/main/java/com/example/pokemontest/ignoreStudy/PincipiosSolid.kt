package com.example.pokemontest.ignoreStudy

open class Animal {
    open fun walk() {}
    open  fun jump() {}
}

fun jumpHole(animal: Animal) {
    animal.walk()
    animal.jump()
    animal.walk()
}

class Elefante: Animal() {
    override fun jump() {

    }
}