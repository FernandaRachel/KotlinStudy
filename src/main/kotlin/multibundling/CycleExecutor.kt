package multibundling

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class CycleExecutor {
    private val counter: AtomicInteger = AtomicInteger(0)

    fun runCarExecutionMode(): Flow<Int> =
        flow {
            var x = 0
            while (x < 10) x++
            counter.addAndGet(1)
            delay(100)
            println("car execution mode ${counter.get()} - ${Date().toInstant()}")
            counter.get()
        }

    fun runMotorcycleExecutionMode(): Flow<Int> =
        flow {
            var x = 0
            while (x < 10) x++
            counter.addAndGet(1)
            println("motorcycle execution mode ${counter.get()} - ${Date().toInstant()}")
            counter.get()
        }

    fun runCarExecutionModeThread(): Int {
        var x = 0
        while (x < 10) x++
        Thread.sleep(100)
        counter.addAndGet(1)
        println("car execution mode ${counter.get()} - ${Date().toInstant()}")
        return counter.get()
    }

    fun runMotorcycleExecutionModeThread(): Int {
        var x = 0
        while (x < 10) x++
        counter.addAndGet(1)
            println("motorcycle execution mode ${counter.get()} - ${Date().toInstant()}")
            return counter.get()
        }
}