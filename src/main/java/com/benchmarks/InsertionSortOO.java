package com.benchmarks;

import com.insertionsort.InsertionSort;
import com.datasources.IntArrayData;
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

public class InsertionSortOO {
    public static void main(String[] args) throws RunnerException, FileNotFoundException {
        Options options = new OptionsBuilder()
                .include(InsertionSortOO.class.getSimpleName())
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

        PrintStream output = new PrintStream(InsertionSortOO.class.getSimpleName() + "-BenchmarkResults.txt");
        System.setOut(output);

        new Runner(options).run();
    }

    @Benchmark
    public void ooBenchmarkArrayOf100() {
        InsertionSort insertionSort = new InsertionSort(IntArrayData.Companion.getArrayOfLength100());
        insertionSort.execute();
    }

    @Benchmark
    public void ooBenchmarkArrayOf200() {
        InsertionSort insertionSort = new InsertionSort(IntArrayData.Companion.getArrayOfLength200());
        insertionSort.execute();
    }

    @Benchmark
    public void ooBenchmarkArrayOf300() {
        InsertionSort insertionSort = new InsertionSort(IntArrayData.Companion.getArrayOfLength300());
        insertionSort.execute();
    }
}
