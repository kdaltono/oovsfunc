package com.benchmarks;

import com.datasources.GraphData;
import com.dijkstrasalgorithm.*;
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

public class DijkstrasAlgorithmFunc {
    public static void main(String[] args) throws RunnerException, FileNotFoundException {
        Options options = new OptionsBuilder()
                .include(DijkstrasAlgorithmFunc.class.getSimpleName())
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

        PrintStream output = new PrintStream(DijkstrasAlgorithmFunc.class.getSimpleName() + "-BenchmarkResults.txt");
        System.setOut(output);

        new Runner(options).run();
    }

    @Benchmark
    public void funcBenchmark5Nodes() {
        FunctionalKt.startDijkstra(GraphData.Companion.returnGraphOfNode5(), 0, 4);
    }

    @Benchmark
    public void funcBenchmark15Nodes() {
        FunctionalKt.startDijkstra(GraphData.Companion.returnGraphOfNode15(), 0, 14);
    }

    @Benchmark
    public void funcBenchmark25Nodes() {
        FunctionalKt.startDijkstra(GraphData.Companion.returnGraphOfNode25(), 0, 24);
    }
}
