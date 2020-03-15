package com.benchmarks;

import com.datasources.GraphData;
import com.kruskalsalgorithm.Graph;
import com.kruskalsalgorithm.Kruskals;
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

public class KruskalsAlgorithmOO {
    public static void main(String[] args) throws RunnerException, FileNotFoundException {
        Options options = new OptionsBuilder()
                .include(KruskalsAlgorithmOO.class.getSimpleName())
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

        PrintStream output = new PrintStream(KruskalsAlgorithmOO.class.getSimpleName() + "-BenchmarkResults.txt");
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
        Kruskals kruskals = new Kruskals(graph5);
        kruskals.executeKruskalsAlgorithm();
        kruskals.printMST();
    }

    @Benchmark
    public void ooBenchmark15Nodes() {
        Kruskals kruskals = new Kruskals(graph15);
        kruskals.executeKruskalsAlgorithm();
        kruskals.printMST();
    }

    @Benchmark
    public void ooBenchmark25Nodes() {
        Kruskals kruskals = new Kruskals(graph25);
        kruskals.executeKruskalsAlgorithm();
        kruskals.printMST();
    }
}
