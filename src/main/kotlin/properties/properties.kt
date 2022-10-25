package test.properties

open class Rectangle() {
    var width: Int = 5
        get() = field
        set(value) {
            field = value
        }
    var height: Int = 2
        get() = field
        set(value) {
            field = value
        }

    val area get() = this.width * this.height

}



fun main() {
    Rectangle().area
}

