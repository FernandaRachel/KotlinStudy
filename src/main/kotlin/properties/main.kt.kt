package otherpack.properties

import test.properties.Rectangle

fun main() {
    val area = Rectangle().area
    println("area: $area")
}

class Square: Rectangle() {
//    override val height = 15
}