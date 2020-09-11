# oovsfunc
Object Oriented and Functional paradigm comparisons in Kotlin programming language.

Four algorithms (Dijkstra's Algorithm, Kruskal's Algorithm, Insertion Sort and Tower of Hanoi) have been implemented in both the Object Oriented and Functional paradigms to compare performance regarding memory usage and runtime.

To compare the algorithms, the Java Benchmark Harness (JMH) was used to collect the JVM's Garbage Collection and runtime data with benchmarks with increased size/complexity inputs.

The JMH benchmarks can be found in src/main/java/com/benchmarks.

The implementations can be found in the corresponding packages in src/main/java/com, named with the corresponding paradigm.
