package multibundling

import kotlinx.coroutines.flow.collect

class PocMbCycleThreads: Runnable {
    private val cycleExecutor = CycleExecutor()

    override fun run() {
        repeat(5) { cycleExecutor.runCarExecutionModeThread() }
        repeat(5) { cycleExecutor.runMotorcycleExecutionModeThread() }
    }
}