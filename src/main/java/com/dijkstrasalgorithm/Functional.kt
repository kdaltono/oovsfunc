package com.dijkstrasalgorithm

fun main() {
    var graph = GraphData.returnGraphOfNode5()

    // TODO: Test functions that haven't been tested yet.
    var start = 0
    var visited : MutableList<Boolean> = MutableList(graph.size) { false }
    var tentativeDistances : MutableList<Int> = MutableList(graph.size) { Int.MAX_VALUE }
    tentativeDistances[start] = 0

    var nextNode = getNextNode(visited, tentativeDistances, start, start, 0)
    println("nextNode: " + nextNode)
    visited[nextNode] = true
    nextNode = getNextNode(visited, tentativeDistances, start, start, 0)
    println("nextNode: " + nextNode)
}

fun dijkstra(graph: Array<IntArray>, startNode: Char, endNode: Char) {
    var start : Int = startNode - 'A'
    var end : Int = endNode - 'A'

    var visited : MutableList<Boolean> = MutableList(graph.size) { false }
    var tentativeDistances : MutableList<Int> = MutableList(graph.size) { Int.MAX_VALUE }
    tentativeDistances[start] = 0


}

fun recursiveDijkstra(visited: MutableList<Boolean>, tentativeDistances: MutableList<Int>, startNode: Int, path: String) : String {
    if (visited.contains(false)) {
        var previousSelection: MutableList<Boolean> = MutableList(visited.size) { false }
        val nextNode = getNextNode(visited, tentativeDistances, startNode, 0, 0)
    } else {
        // Done
        return path
    }
    return ""
}

fun visitNode(graph: Array<IntArray>, visited: MutableList<Boolean>, tentativeDistances: MutableList<Int>, previousSelection: MutableList<Boolean>, currentNode: Int, count: Int) {
    if (count > graph.size - 1) {
        var currentNeighbour = getNextNeighbour(graph, previousSelection, currentNode, 0, 0)
        previousSelection[currentNeighbour] = true
        updateDistance(graph, tentativeDistances, currentNode, currentNeighbour)
        visitNode(graph, visited, tentativeDistances, previousSelection, currentNode, count)
    } else {
        return
    }
}

fun getNextNeighbour(graph: Array<IntArray>, previousSelection: MutableList<Boolean>, currentNode: Int, currentNeighbour: Int, shortestNeighbour: Int) : Int {
    if (currentNeighbour > graph.size - 1) {
        return shortestNeighbour
    } else if (graph[currentNode][currentNeighbour] != -1) {
        if (graph[currentNode][shortestNeighbour] == -1) {
            return getNextNeighbour(graph, previousSelection, currentNode, currentNeighbour + 1, shortestNeighbour + 1)
        } else if (graph[currentNode][currentNeighbour] < graph[currentNode][shortestNeighbour] && !previousSelection[currentNeighbour]) {
            return getNextNeighbour(graph, previousSelection, currentNode, currentNeighbour + 1, currentNeighbour)
        } else if (previousSelection[currentNeighbour]) {
            return getNextNeighbour(graph, previousSelection, currentNode, currentNeighbour + 1, shortestNeighbour)
        } else {
            return getNextNeighbour(graph, previousSelection, currentNode, currentNeighbour + 1, shortestNeighbour)
        }
    } else {
        return getNextNeighbour(graph, previousSelection, currentNode, currentNeighbour + 1, shortestNeighbour)
    }
}

fun getNextNode(visited: MutableList<Boolean>, tentativeDistances: MutableList<Int>, startNode: Int, currentShortest: Int, count: Int) : Int {
    if (count < visited.size) {
        if (!visited[count] && tentativeDistances[count] < tentativeDistances[currentShortest] /*&& startNode != currentShortest*/) {
            return getNextNode(visited, tentativeDistances, startNode, count, count + 1)
        } /*else if (startNode == currentShortest && !visited[startNode]) {
            return startNode
        } */else if (visited[count]) {
            return getNextNode(visited, tentativeDistances, startNode, currentShortest, count + 1)
        }
    } else {
        return currentShortest
    }
    return -1;
}

fun updateDistance(graph: Array<IntArray>, tentativeDistances: MutableList<Int>, currentNode: Int, endNode: Int) {
    if (tentativeDistances[endNode] > graph[currentNode][endNode])
        tentativeDistances[endNode] = graph[currentNode][endNode]
}