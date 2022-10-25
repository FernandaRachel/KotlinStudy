fun main() {
    val thread1 = Thread(method1())
    val thread2 = Thread(method2())
    val thread3 = Thread(method3())
    println(thread1.start())
    println(thread2.start())
    println(thread3.start())
}

private fun method1() = "Hey "
private fun method2(): String {
    Thread.sleep(100);
    return "Ho"
}

private fun method3() = "Let's go"
