package classes

class PetStore(val pets: MutableList<Pet> = mutableListOf())

class Pet {
    constructor(owner: PetStore) {
        owner.pets.add(this) // adds this pet to the list of its owner's pets
    }
}

fun main() {
    val x = PetStore()
    println(x)
}