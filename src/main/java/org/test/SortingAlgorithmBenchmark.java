package org.test;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.openjdk.jmh.annotations.*;
import org.test.utils.SortingAlgorithm;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(2)
public class SortingAlgorithmBenchmark {

    private final int RANDOM_SEED = 10000;

    private final EasyRandomParameters parameters = new EasyRandomParameters()
            .seed(RANDOM_SEED);

    private final EasyRandom easyRandom = new EasyRandom(parameters);

    @Param({"100", "1000", "10000"})
    private int arraySize;

    @Param({"asc", "desc", "rand"})
    private String dataOrder;

    private Integer[] integerArray;

    @Setup(Level.Invocation)
    public void beforeInvocation() {
        assert Objects.equals(dataOrder, "asc")
                || Objects.equals(dataOrder, "desc")
                || Objects.equals(dataOrder, "rand");

        if (dataOrder.equals("asc")) {
            integerArray = IntStream.range(0, arraySize)
                    .boxed().toArray(Integer[]::new);
        }
        if (dataOrder.equals("desc")) {
            integerArray = IntStream.iterate(arraySize - 1, i -> i - 1).limit(arraySize)
                    .boxed().toArray(Integer[]::new);
        }
        if (dataOrder.equals("rand")) {
            // Всегда один и тот же порядок.
            integerArray = IntStream.range(0, arraySize).map(i -> easyRandom.nextInt())
                    .boxed().toArray(Integer[]::new);
        }
    }

    @Benchmark
    public Integer[] bubbleSort() {
        SortingAlgorithm.bubbleSort(integerArray);
        return integerArray;
    }

    @Benchmark
    public Integer[] quickSort() {
        SortingAlgorithm.quickSort(integerArray);
        return integerArray;
    }
}
