package multibundling

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class PocMbCycle {


    private val cycleExecutor = CycleExecutor()

    // Sequentially executes doWorld followed by "Done"
    fun main() = runBlocking {
//        doWorld()
        runAllInParallel()
        println("Done")
    }

    var value = "Hello"

    // Concurrently executes both sections
    suspend fun doWorld() = coroutineScope { // this: CoroutineScope
        launch {
            repeat(5) { cycleExecutor.runCarExecutionMode().collect() }
            value = "Hello Thread 1"
            println(value)
        }

        launch {
            repeat(5) { cycleExecutor.runMotorcycleExecutionMode().collect() }
            value = "Hello Thread 2"
            println(value)
        }
        println(value)
    }

    suspend fun runAllInParallel() = coroutineScope {
        awaitAll(async {
            repeat(5) { cycleExecutor.runCarExecutionMode().collect() }
            value = "Hello Thread 1"
            println(value)
        }, async {
            launch {
                repeat(5) { cycleExecutor.runMotorcycleExecutionMode().collect() }
                value = "Hello Thread 2"
                println(value)
            }
        })
    }

}

/**
 * -----------------------------------------------------
 * */
fun execution() {
    val mutex = Mutex()
    var counter = 0

    fun main() = runBlocking {
        withContext(Dispatchers.Default) {
            massiveRun {
                // protect each increment with lock
                mutex.withLock {
                    counter++
                }
            }
        }
        println("Counter = $counter")
    }
}

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}
