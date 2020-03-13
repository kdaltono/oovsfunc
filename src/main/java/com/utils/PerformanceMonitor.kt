package com.utils

class PerformanceMonitor {
    var memoryUsage : MemoryUsage = MemoryUsage()
    var runtimeTimer : RuntimeTimer = RuntimeTimer()

    fun startPerformanceMonitor() {
        runtimeTimer.startTimer()
    }

    fun endPerformanceMonitor() {
        var totalRuntime : Long = runtimeTimer.endTimer()
        println("Total Runtime: " + totalRuntime + "ns")
        memoryUsage.endMemoryTracker()
    }
}