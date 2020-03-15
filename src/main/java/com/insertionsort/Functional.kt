package com.insertionsort

fun insertionSort(array: IntArray, start: Int, end: Int) : IntArray {
    if (start < end) {
        if (array[start] > array[start + 1]) {
            val sortedArray = sort(array, start + 1)
            return insertionSort(sortedArray, start + 1, end)
        } else {
            return insertionSort(array, start + 1, end)
        }
    } else {
        return array
    }
}

fun sort(array: IntArray, pos: Int) : IntArray {
    if (pos > 0) {
        if (array[pos] < array[pos - 1]) {
            var temp = array[pos]
            array[pos] = array[pos - 1]
            array[pos - 1] = temp
            return sort(array, pos - 1)
        } else {
            return sort(array, pos - 1)
        }
    } else {
        return array
    }
}

fun printArray(array: IntArray, start: Int, length: Int, msg: String) {
    if (start < length) {
        printArray(array, start + 1, length, msg + array[start].toString() + " ")
    } else {
        println(msg)
    }
}