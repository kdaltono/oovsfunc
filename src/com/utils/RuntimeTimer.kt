package com.utils

class RuntimeTimer {
    var startTime : Long = 0
    var endTime : Long = 0

    fun startTimer() {
        startTime = System.nanoTime()
    }

    fun endTimer() : Long {
        endTime = System.nanoTime()
        return endTime - startTime
    }
}