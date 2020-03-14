package com.benchmarks;

import com.dijkstrasalgorithm.Dijkstra;
import com.dijkstrasalgorithm.Graph;
import com.dijkstrasalgorithm.GraphData;
import com.dijkstrasalgorithm.Vertex;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)

public class DijkstrasAlgorithmOO {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(DijkstrasAlgorithmOO.class.getSimpleName())
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(1L))
                .warmupIterations(5)
                .threads(1)
                .measurementIterations(15)
                .forks(1)
                .addProfiler(GCProfiler.class)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public void ooBenchmark5Nodes() {
        Graph graph = new Graph(GraphData.Companion.returnGraphOfNode5());
        Vertex start = graph.getVertices().get(0);
        Vertex end = graph.getVertices().get(4);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(start, end);
    }

    @Benchmark
    public void ooBenchmark15Nodes() {
        Graph graph = new Graph(GraphData.Companion.returnGraphOfNode15());
        Vertex start = graph.getVertices().get(0);
        Vertex end = graph.getVertices().get(14);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(start, end);
    }

    @Benchmark
    public void ooBenchmark25Nodes() {
        Graph graph = new Graph(GraphData.Companion.returnGraphOfNode25());
        Vertex start = graph.getVertices().get(0);
        Vertex end = graph.getVertices().get(24);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(start, end);
    }
}
