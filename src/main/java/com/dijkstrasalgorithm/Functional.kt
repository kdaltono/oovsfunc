package com.dijkstrasalgorithm

/*fun main() {
    val graph: Array<IntArray> = GraphData.returnGraphOfNode5()
    startDijkstra(graph, 4, 0)
}*/

fun startDijkstra(graph: Array<IntArray>, startNode: Int, endNode: Int) {
    var visitedNodes : BooleanArray = BooleanArray(graph.size) { false } // Holds visited nodes
    var tentativeDistances : IntArray = IntArray(graph.size) { Int.MAX_VALUE - 1 }
    tentativeDistances[startNode] = 0

    tentativeDistances = recursiveDijkstra(graph, visitedNodes, tentativeDistances, startNode)
    val startChar: Char = (startNode + 'A'.toInt()).toChar()
    val endChar: Char = (endNode + 'A'.toInt()).toChar()
    println("Distance from " + startChar + " to " + endChar + " is: " + tentativeDistances[endNode])
}

fun recursiveDijkstra(graph: Array<IntArray>, visited: BooleanArray, tentativeDistances: IntArray, currentNode: Int) : IntArray {
    var tentDist = visitNode(graph, tentativeDistances, currentNode, 0)
    visited[currentNode] = true
    var nextNode = getNextNode(tentDist, visited, Int.MAX_VALUE, -1, 0)
    if (visited.contains(false)) {
        return recursiveDijkstra(graph, visited, tentDist, nextNode)
    } else {
        return tentDist
    }
}

fun visitNode(graph: Array<IntArray>, tentativeDistances: IntArray, currentNode: Int, currentNeighbour: Int) : IntArray {
    if (currentNeighbour < graph.size) {
        if (currentNeighbour == currentNode) {
            return visitNode(graph, tentativeDistances, currentNode, currentNeighbour + 1)
        }

        var neighbourDistance = tentativeDistances[currentNode] + graph[currentNode][currentNeighbour]
        if (neighbourDistance < tentativeDistances[currentNeighbour] && graph[currentNode][currentNeighbour] != -1) {
            tentativeDistances[currentNeighbour] = neighbourDistance
            return visitNode(graph, tentativeDistances, currentNode, currentNeighbour + 1)
        } else {
            return visitNode(graph, tentativeDistances, currentNode, currentNeighbour + 1)
        }
    } else {
        return tentativeDistances
    }
}

fun getNextNode(tentativeDistances: IntArray, visited: BooleanArray, shortestDistance: Int, shortestNode: Int, currentNode: Int) : Int {
    if (currentNode < visited.size) {
        val currentDistance = tentativeDistances[currentNode]
        if (!visited[currentNode] && currentDistance < shortestDistance)
            return getNextNode(tentativeDistances, visited, currentDistance, currentNode, currentNode + 1)
        else
            return getNextNode(tentativeDistances, visited, shortestDistance, shortestNode, currentNode + 1)
    } else
        return shortestNode
}

