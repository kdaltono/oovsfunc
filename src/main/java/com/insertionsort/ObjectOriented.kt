package com.insertionsort

class InsertionSort(array: IntArray) {
    private var array: IntArray = array

    fun execute() {
        val length = array.size

        for (i in 0 until length - 1) {
            if (array[i] > array[i + 1]) {
                sort(i)
            }
        }

        printArray(length)
    }

    private fun sort(loc: Int) {
        for (i in loc + 1 downTo 1) {
            if (array[i] < array[i - 1]) {
                var temp = array[i]
                array[i] = array[i - 1]
                array[i - 1] = temp
            }
        }
    }

    private fun printArray(length: Int) {
        var msg: String = ""
        for (i in 0 until length) {
            msg += array[i].toString() + " "
        }
        println(msg)
    }
}