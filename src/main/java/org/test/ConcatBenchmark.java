package org.test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(2)
public class ConcatBenchmark {

    private final String TEXT_FOR_CONCAT = "TEXT_FOR_CONCAT";
    private final int ITERATION_COUNT = 1000;
    private int iterationNumber = 0;

    @Benchmark
    public String stringBuilder() {
        StringBuilder stringBuilder = new StringBuilder(TEXT_FOR_CONCAT);
        for (int i = 0; i < ITERATION_COUNT; i++) {
            stringBuilder.append(TEXT_FOR_CONCAT).append(iterationNumber++);
        }
        return stringBuilder.toString();
    }

    @Benchmark
    public String stringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(TEXT_FOR_CONCAT);
        for (int i = 0; i < ITERATION_COUNT; i++) {
            stringBuffer.append(TEXT_FOR_CONCAT).append(iterationNumber++);
        }
        return stringBuffer.toString();
    }

    @Benchmark
    public String stringConcat() {
        String str = TEXT_FOR_CONCAT;
        for (int i = 0; i < ITERATION_COUNT; i++) {
            str += TEXT_FOR_CONCAT + iterationNumber++;
        }
        return str;
    }
}
