package com.benchmarks;

import com.towerofhanoi.ObjectOriented;
import com.towerofhanoi.Stack;
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

public class TowerOfHanoiOO {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(TowerOfHanoiOO.class.getSimpleName())
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
    public void ooBenchmark3Disks() {
        initializeBenchmark(3);
    }

    @Benchmark
    public void ooBenchmark9Disks() {
        initializeBenchmark(9);
    }

    @Benchmark
    public void ooBenchmark15Disks() {
        initializeBenchmark(15);
    }

    private void initializeBenchmark(int numOfDisks) {
        ObjectOriented oo;
        oo = new ObjectOriented();
        Stack src = oo.createStack(numOfDisks);
        Stack dest = oo.createStack(numOfDisks);
        Stack aux = oo.createStack(numOfDisks);
        oo.iterativeLoop(numOfDisks, src, aux, dest);
    }
}
