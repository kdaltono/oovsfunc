package com.dijkstrasalgorithm

/* This class holds the graphs that Functional.kt and ObjectOriented.kt will solve. Having one file to store both
 * means it will be less likely for there to be inconsistencies between the two. */

class GraphData {
    companion object {
        fun returnGraphOfNode5() : Array<IntArray> {
            var intArray: Array<IntArray> = arrayOf(
                intArrayOf(-1, 10, 14, -1, -1),
                intArrayOf(10, -1, 15,  4, -1),
                intArrayOf(14, 15, -1,  7, 12),
                intArrayOf(-1,  4,  7, -1, -1),
                intArrayOf(-1, -1, 12, -1, -1)
            )
            return intArray
        }


    }
}