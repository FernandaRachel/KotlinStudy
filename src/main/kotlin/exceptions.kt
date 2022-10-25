fun main() {
    println(a)
    fail("Wops")
    println(s)     // 's' is known to be initialized at this point

}

val a: Int? = try { "1K".toInt() } catch (e: NumberFormatException) { throw  Exception("Parse error: $e") }

const val person = ""
val s = person ?: fail("Name required")

// Nothing. This type has no values and is used to mark code locations that can never be reached
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}