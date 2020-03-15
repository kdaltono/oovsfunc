package com.kruskalsalgorithm

import com.datasources.GraphData

class Vertex(id: String, name: String) {
    private var id: String = id
    private var name: String = name

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
    private var id: String = id
    private var source: Vertex = source
    private var destination: Vertex = destination
    private var weight: Int = weight

    fun getId() : String {
        return id
    }

    fun getSource() : Vertex {
        return source
    }

    fun getDestination() : Vertex {
        return destination
    }

    fun getWeight() : Int {
        return weight
    }

    override fun toString(): String {
        return (source.toString() + " to " + destination.toString() + ", Weight: " + weight)
    }
}

class Graph(rawGraph: Array<IntArray>) {
    private var vertices: MutableList<Vertex>
    private var edges: MutableList<Edge>

    init {
        var vertexCount = rawGraph.size
        vertices = mutableListOf()
        edges = mutableListOf()

        var name: Char = 'A'
        var id: Int = 0
        for (i in 0 until vertexCount) {
            var newVertex = Vertex(id.toString(), name.toString())
            vertices.add(newVertex)
            name++
            id++
        }

        for (x in 0 until vertexCount) {
            var yVertex = vertices.get(x)
            for (y in 0 until vertexCount) {
                if (rawGraph[x][y] != -1) {
                    var xVertex = vertices.get(y)
                    var id: Int = x + y
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

// Kruskals Class that will perform Kruskal's algorithm
class Kruskals(graph: Graph) {
    private var nodes : MutableList<Vertex> = graph.getVertices()
    private var edges : MutableList<Edge> = graph.getEdges()
    private var connectedNodes : MutableSet<Vertex> = mutableSetOf()
    private var MST : MutableSet<Edge> = mutableSetOf()

    fun executeKruskalsAlgorithm() {
        var vertexSize: Int = nodes.size
        var sortedEdges = edges.sortedBy { edge -> edge.getWeight() }
        var iterator = sortedEdges.iterator()

        while (MST.size != vertexSize - 1 && iterator.hasNext()) {
            var edge: Edge = iterator.next()

            if (!(connectedNodes.contains(edge.getSource()) &&
                        connectedNodes.contains(edge.getDestination()))) {
                MST.add(edge)
                connectedNodes.add(edge.getSource())
                connectedNodes.add(edge.getDestination())
            }
        }
    }

    fun printMST() {
        var iterator = MST.iterator()
        while (iterator.hasNext()) {
            var edge = iterator.next()
            println(edge.toString())
        }
    }
}

fun main() {
    var graph = Graph(GraphData.returnGraphOfNode5())
    var kruskal = Kruskals(graph)
    kruskal.executeKruskalsAlgorithm()
    kruskal.printMST()
}