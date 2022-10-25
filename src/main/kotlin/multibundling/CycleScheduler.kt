package multibundling

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class CycleScheduler {

    val poc: PocMbCycle = PocMbCycle()
    val pocThreads: PocMbCycleThreads = PocMbCycleThreads()


}

suspend fun main() {
    val scheduler: CycleScheduler = CycleScheduler()

    println("------------- Coroutines --------------------")
    val initDate = Date().toInstant().toEpochMilli()
    scheduler.poc.doWorld()
    val endDate = Date().toInstant().toEpochMilli()
    println("${endDate - initDate}")
    println("------------- Threads --------------------")

    val initDate2 = Date().toInstant().toEpochMilli()
    scheduler.pocThreads.run()
    val endDate2 = Date().toInstant().toEpochMilli()
    println("${endDate2 - initDate2}")
}