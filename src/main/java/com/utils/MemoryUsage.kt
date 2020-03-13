package com.utils

import java.lang.management.ManagementFactory

class MemoryUsage {
    private var newMemVar: Long = 0
    private var curMemVar: Long = 0

    private var memBean = ManagementFactory.getMemoryMXBean()

    fun endMemoryTracker() {
        var heap = memBean.heapMemoryUsage;
        var nonHeap = memBean.nonHeapMemoryUsage
        var totalMem = (heap.used + nonHeap.used) / 1_000
        var heapUsage = (heap.used) / 1_000
        var nonHeapUsage = (nonHeap.used) / 1_000
        println("Heap Memory Usage:     " + heapUsage.toString() + "KB")
        println("Non Heap Memory Usage: " + nonHeapUsage.toString() + "KB")
        println("Total Memory Usage:    " + totalMem.toString() + "KB")
    }

}