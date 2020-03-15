package com.kruskalsalgorithm

import com.datasources.GraphData

fun startKruskals(graph: Array<IntArray>) {
    var connectedNodes: BooleanArray = BooleanArray(graph.size) {false}
    var edges: MutableList<IntArray> = mutableListOf()
    edges = getAllEdges(graph, 1, 0, 0, edges)
    var sortedEdges = edges.sortedBy { array -> array[2] }
    findMST(sortedEdges, connectedNodes, 0)
}

fun getAllEdges(graph: Array<IntArray>, x: Int, y: Int, count: Int, edges: MutableList<IntArray>) : MutableList<IntArray> {
    var graphSize = graph.size
    if (x < graphSize && y < graphSize) {
        var weight = graph[x][y]
        if (weight != -1) {
            edges.add(intArrayOf(x, y, weight)) // Error here
            return getAllEdges(graph, x + 1, y, count + 1, edges)
        } else {
            return getAllEdges(graph, x + 1, y, count + 1, edges)
        }
    } else if (y >= graphSize) {
        return edges
    } else if (x >= graphSize) {
        return getAllEdges(graph, 0, y + 1, count + 1, edges)
    } else {
        return edges
    }
}

fun findMST(sortedEdges: List<IntArray>, connectedNodes: BooleanArray, count: Int) : BooleanArray {
    if (count < sortedEdges.size) {
        var edge = sortedEdges[count]
        var srcNode = edge[0]
        var destNode = edge[1]
        if (!(connectedNodes[srcNode] && connectedNodes[destNode])) {
            var src: Char = srcNode.toChar() + 'A'.toInt()
            var dest: Char = destNode.toChar() + 'A'.toInt()
            println(src + " to " + dest + ", Weight: " + edge[2])
            connectedNodes[srcNode] = true
            connectedNodes[destNode] = true
            return findMST(sortedEdges, connectedNodes, count + 1)
        } else {
            return findMST(sortedEdges, connectedNodes, count + 1)
        }
    } else {
        return connectedNodes
    }
}