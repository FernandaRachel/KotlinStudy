package classes

class Person(private val firstName: String? = "Fernanda") {

    init {
        println(firstName)
    }

    init {
        println(firstName?.uppercase() + 1)
    }
}
// this way you can initialize later
lateinit var string: String

fun main() {
    var x = Person("Fer R")
}