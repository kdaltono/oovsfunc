package com.dijkstrasalgorithm

import com.utils.MemoryUsage
import com.utils.PerformanceMonitor
import java.lang.RuntimeException
import java.util.*

class Vertex(id : String, name : String) {
    private var id : String = id
    private var name : String = name

    fun getId() : String {
        return id
    }

    fun getName() : String {
        return name
    }

    override fun toString(): String {
        return name
    }

    override fun equals(obj: Any?): Boolean {
        var other : Vertex = obj as Vertex
        if (this.name == other.name && this.id == other.id) return true
        return false
    }
}

class Edge(id : String, source : Vertex, destination : Vertex, weight : Int) {
    private var id : String = id
    private var source : Vertex = source
    private var destination : Vertex = destination
    private var weight : Int = weight

    fun getId() : String {
        return id
    }

    fun getDestination() : Vertex {
        return destination
    }

    fun getSource() : Vertex {
        return source
    }

    fun getWeight() : Int {
        return weight
    }

    override fun toString(): String {
        return (source.toString() + " " + destination.toString())
    }
}

class Graph(rawGraph : Array<IntArray>) {
    private var vertices : MutableList<Vertex>
    private var edges : MutableList<Edge>

    init {
        var vertexCount = rawGraph.size
        vertices = mutableListOf()
        edges = mutableListOf()

        // Populate Vertices List
        var name : Char = 'A'
        var id : Int = 0
        for (i in 0 until vertexCount) {
            var newVertex = Vertex(id.toString(), name.toString())
            vertices.add(newVertex)
            name++
            id++
        }

        // Populate Edges
        for (x in 0 until vertexCount) {
            var yVertex = vertices.get(x)
            for (y in 0 until vertexCount) {
                if (rawGraph[x][y] != -1) {
                    var xVertex = vertices.get(y)
                    var id : Int = x + y
                    var weight : Int = rawGraph[x][y]
                    var newEdge : Edge = Edge(id.toString(), yVertex, xVertex, weight)
                    edges.add(newEdge)
                }
            }
        }
    }

    fun getVertices() : MutableList<Vertex> {
        return vertices
    }

    fun getEdges() : MutableList<Edge> {
        return edges
    }
}

class Dijkstra(graph : Graph) {
    private var nodes : MutableList<Vertex> = graph.getVertices()
    private var edges : MutableList<Edge> = graph.getEdges()
    private var settledNodes : MutableSet<Vertex> = mutableSetOf()
    private var unsettledNodes : MutableSet<Vertex> = mutableSetOf()
    private var predecessors : MutableMap<Vertex, Vertex> = mutableMapOf()
    private var distance : MutableMap<Vertex, Int> = mutableMapOf()

    fun execute(source : Vertex, destination: Vertex) {
        distance.put(source, 0)
        unsettledNodes.add(source)
        while (unsettledNodes.size > 0) {
            var node : Vertex? = getMinimum(unsettledNodes)
            settledNodes.add(node!!)
            unsettledNodes.remove(node)
            findMinimalDistance(node)
        }
        println("Distance from " + source.getName() + " to " + destination.getName() + " is " +
                distance.get(destination))
    }

    fun findMinimalDistance(node : Vertex) {
        var adjacentNodes : List<Vertex> = getNeighbours(node)
        for (target: Vertex in adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target))
                predecessors.put(target, node)
                unsettledNodes.add(target)
            }
        }
    }

    fun getDistance(node : Vertex, target : Vertex) : Int {
        for (edge : Edge in edges) {
            if (edge.getSource() == node && edge.getDestination() == target) {
                return edge.getWeight()
            }
        }
        throw RuntimeException("Shouldn't happen")
    }

    fun getNeighbours(node : Vertex) : MutableList<Vertex> {
        var neighbours : MutableList<Vertex> = mutableListOf()
        for (edge: Edge in edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbours.add(edge.getDestination())
            }
        }
        return neighbours
    }

    fun isSettled(vertex: Vertex) : Boolean {
        return settledNodes.contains(vertex)
    }

    fun getMinimum(vertexes : MutableSet<Vertex>) : Vertex? {
        var minimum : Vertex? = null
        for (v : Vertex in vertexes) {
            if (minimum == null) {
                minimum = v
            } else {
                if (getShortestDistance(v) < getShortestDistance(minimum)) {
                    minimum = v
                }
            }
        }
        return minimum
    }

    fun getShortestDistance(destination: Vertex) : Int {
        var d : Int? = distance.get(destination)
        if (d == null) {
            return Integer.MAX_VALUE
        } else {
            return d
        }
    }
}

fun main() {
    var performanceTracker : PerformanceMonitor = PerformanceMonitor()
    performanceTracker.startPerformanceMonitor()
    var graph : Graph = Graph(GraphData.returnGraphOfNode5())
    var startNode = graph.getVertices().get(0)
    var endNode = graph.getVertices().get(graph.getVertices().lastIndex)
    var dijkstra : Dijkstra = Dijkstra(graph)
    dijkstra.execute(startNode, endNode)
    performanceTracker.endPerformanceMonitor()
}