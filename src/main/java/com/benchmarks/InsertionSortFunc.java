package com.benchmarks;

import com.insertionsort.FunctionalKt;
import com.insertionsort.IntArrayData;
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

public class InsertionSortFunc {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(InsertionSortFunc.class.getSimpleName())
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
    public void funcBenchmarkArrayOf100() {
        initializeFunctionalBenchmark(IntArrayData.Companion.getArrayOfLength100(), 100);
    }

    @Benchmark
    public void funcBenchmarkArrayOf200() {
        initializeFunctionalBenchmark(IntArrayData.Companion.getArrayOfLength200(), 200);
    }

    @Benchmark
    public void funcBenchmarkArrayOf300() {
        initializeFunctionalBenchmark(IntArrayData.Companion.getArrayOfLength300(), 300);
    }

    private void initializeFunctionalBenchmark(int[] testData, int length) {
        int[] array = FunctionalKt.insertionSort(testData, 0, length - 1);
        FunctionalKt.printArray(array, 0, length, "");
    }
}
