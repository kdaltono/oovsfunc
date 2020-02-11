package com.towerofhanoi

import com.utils.MemoryUsage
import com.utils.PerformanceMonitor

var performanceMonitor : PerformanceMonitor = PerformanceMonitor()

fun main() {
    performanceMonitor.startPerformanceMonitor()
    val numOfTypes = 3
    solveTower(numOfTypes, 'A', 'B', 'C')
    performanceMonitor.endPerformanceMonitor()
}

fun solveTower(a: Int, from: Char, aux: Char, to: Char) {
    if (a == 1) {
        println("Move disc 1 from " + from + " to " + to)
    } else {
        solveTower(a - 1, from, to, aux)
        println("Move disc " + a + " from " + from + " to " + to)
        solveTower(a - 1, aux, from, to)
    }
}