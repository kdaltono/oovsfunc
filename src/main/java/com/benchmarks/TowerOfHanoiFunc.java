package com.benchmarks;

import com.towerofhanoi.FunctionalKt;
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

public class TowerOfHanoiFunc {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(TowerOfHanoiFunc.class.getSimpleName())
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
    public void funcBenchmark3Disks() {
        initializeBenchmark(3);
    }

    @Benchmark
    public void funcBenchmark9Disks() {
        initializeBenchmark(9);;
    }

    @Benchmark
    public void funcBenchmark15Disks() {
        initializeBenchmark(15);
    }

    private void initializeBenchmark(int numOfDisks) {
        FunctionalKt.solveTower(numOfDisks, 'A', 'B', 'C');
    }
}
