package com.benchmarks;

import com.dijkstrasalgorithm.Dijkstra;
import com.dijkstrasalgorithm.Graph;
import com.datasources.GraphData;
import com.dijkstrasalgorithm.Vertex;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)

public class DijkstrasAlgorithmOO {
    public static void main(String[] args) throws RunnerException, FileNotFoundException {
        Options options = new OptionsBuilder()
                .include(DijkstrasAlgorithmOO.class.getSimpleName())
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(1L))
                .warmupIterations(5)
                .threads(1)
                .measurementIterations(25)
                .forks(1)
                .addProfiler(GCProfiler.class)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        PrintStream output = new PrintStream(DijkstrasAlgorithmOO.class.getSimpleName() + "-BenchmarkResults.txt");
        System.setOut(output);

        new Runner(options).run();
    }

    private Graph graph5, graph15, graph25;

    @Setup
    public void setup() {
        graph5 = new Graph(GraphData.Companion.returnGraphOfNode5());
        graph15 = new Graph(GraphData.Companion.returnGraphOfNode15());
        graph25 = new Graph(GraphData.Companion.returnGraphOfNode25());
    }

    @Benchmark
    public void ooBenchmark5Nodes() {
        Vertex start = graph5.getVertices().get(0);
        Vertex end = graph5.getVertices().get(4);
        Dijkstra dijkstra = new Dijkstra(graph5);
        dijkstra.execute(start, end);
    }

    @Benchmark
    public void ooBenchmark15Nodes() {
        Vertex start = graph15.getVertices().get(0);
        Vertex end = graph15.getVertices().get(14);
        Dijkstra dijkstra = new Dijkstra(graph15);
        dijkstra.execute(start, end);
    }

    @Benchmark
    public void ooBenchmark25Nodes() {
        Vertex start = graph25.getVertices().get(0);
        Vertex end = graph25.getVertices().get(24);
        Dijkstra dijkstra = new Dijkstra(graph25);
        dijkstra.execute(start, end);
    }
}
