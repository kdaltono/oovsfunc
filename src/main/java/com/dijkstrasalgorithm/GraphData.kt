package com.dijkstrasalgorithm

/* This class holds the graphs that Functional.kt and ObjectOriented.kt will solve. Having one file to store both
 * means there will be no inconsistencies between both tests. */

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

        fun returnGraphOfNode15() : Array<IntArray> {
            var intArray: Array<IntArray> = arrayOf(
                intArrayOf(-1,  6,  5, -1,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // A
                intArrayOf( 6, -1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // B
                intArrayOf( 5, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // C
                intArrayOf(-1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // D
                intArrayOf( 7,  8, -1,  4, -1, -1,  4, -1,  2, -1, -1, -1, -1, -1, -1), // E
                intArrayOf(-1, -1,  1, -1, -1, -1,  5, -1, -1, -1, -1, -1, -1, -1, -1), // F
                intArrayOf(-1, -1, -1, -1,  4,  5, -1,  4, -1, -1, -1,  9, -1,  8, -1), // G
                intArrayOf(-1, -1, -1, -1, -1, -1,  4, -1, -1, -1, 12, -1, -1, -1, -1), // H
                intArrayOf(-1, -1, -1, -1,  2, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1), // I
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1,  4, -1,  2, -1, -1, 11,  8), // J
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, 12, -1,  2, -1, -1, -1, -1, -1), // K
                intArrayOf(-1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1,  4, -1, -1), // L
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4, -1,  5, -1), // M
                intArrayOf(-1, -1, -1, -1, -1, -1,  8, -1, -1, 11, -1, -1,  5, -1,  4), // N
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1, -1, -1,  4, -1)  // O
            )
            return intArray
        }

        fun returnGraphOfNode25() : Array<IntArray> {
            var intArray: Array<IntArray> = arrayOf(
                intArrayOf(-1,  4, -1,  5,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // A
                intArrayOf( 4, -1,  4, -1, -1, -1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // B
                intArrayOf(-1,  4, -1, -1, -1, -1,  5,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // C
                intArrayOf( 5, -1, -1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // D
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1,  2,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // E
                intArrayOf(-1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // F
                intArrayOf(-1, -1,  5, -1, -1, -1, -1, -1,  1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // G
                intArrayOf(-1, -1,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // H
                intArrayOf(-1,  8, -1, -1,  2, -1,  1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // I
                intArrayOf(-1, -1, -1, -1,  5, -1, -1, -1, -1, -1,  4, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // J
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, 12,  4, -1, -1, -1, -1,  7,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1), // K
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  2, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1), // L
                intArrayOf(-1, -1, -1, -1, -1, -1,  4,  5, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), // M
                intArrayOf(-1, -1, -1, -1, -1, 15, -1, -1, -1, 12, -1, -1, -1, -1,  5, -1, -1, -1,  6, -1, -1, -1, -1, -1, -1), // N
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  7, -1, -1,  5, -1, -1, -1,  6, -1,  8, -1, -1, -1, -1, -1), // O
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5,  2, -1, -1, -1, -1,  5, -1, -1, -1, -1, -1, -1, -1, -1), // P
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5, -1, -1, -1, -1, -1, -1, 12, -1, -1), // Q
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  6, -1, -1, -1, -1, -1, -1,  4,  4, -1, -1), // R
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  6, -1, -1, -1, -1, -1, -1,  5, -1, -1, -1, -1), // S
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1, -1, -1, -1, -1,  8,  2, -1, -1, -1), // T
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5,  8, -1, -1, -1, -1, -1), // U
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4, -1,  2, -1, -1, -1,  4,  6), // V
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12,  4, -1, -1, -1, -1, -1,  2, -1), // W
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4,  2, -1,  5), // X
                intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  6, -1,  5, -1)  // Y
            )
            return intArray
        }
    }
}