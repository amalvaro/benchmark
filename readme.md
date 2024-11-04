
<b>System info</b>
```
OS:           macOS Sequoia 15.1
Chip:         Apple M2 (ARM)
JMH version:  1.37
VM version:   JDK 21.0.2, OpenJDK 64-Bit Server VM, 21.0.2+13-58
```

<b>1. String Concat</b>

```
Benchmark                      Mode  Cnt     Score     Error  Units
ConcatBenchmark.stringBuffer   avgt    6    18,660 ±   2,274  us/op
ConcatBenchmark.stringBuilder  avgt    6    16,313 ±   2,387  us/op
ConcatBenchmark.stringConcat   avgt    6  1874,900 ± 252,194  us/op
```

<b>2. Sorting</b>
```
Benchmark                             (arraySize)  (dataOrder)  Mode  Cnt       Score       Error  Units
SortingAlgorithmBenchmark.bubbleSort          100          asc  avgt    6       0,038 ±     0,002  us/op
SortingAlgorithmBenchmark.bubbleSort          100         desc  avgt    6      16,578 ±     0,880  us/op
SortingAlgorithmBenchmark.bubbleSort          100         rand  avgt    6      12,378 ±     2,535  us/op
SortingAlgorithmBenchmark.bubbleSort         1000          asc  avgt    6       0,332 ±     0,003  us/op
SortingAlgorithmBenchmark.bubbleSort         1000         desc  avgt    6    1440,873 ±    55,267  us/op
SortingAlgorithmBenchmark.bubbleSort         1000         rand  avgt    6     780,223 ±   390,267  us/op
SortingAlgorithmBenchmark.bubbleSort        10000          asc  avgt    6       4,863 ±     2,129  us/op
SortingAlgorithmBenchmark.bubbleSort        10000         desc  avgt    6  102511,444 ±  3938,156  us/op
SortingAlgorithmBenchmark.bubbleSort        10000         rand  avgt    6  106599,576 ± 17830,589  us/op

SortingAlgorithmBenchmark.quickSort           100          asc  avgt    6       0,664 ±     0,023  us/op
SortingAlgorithmBenchmark.quickSort           100         desc  avgt    6       0,847 ±     0,030  us/op
SortingAlgorithmBenchmark.quickSort           100         rand  avgt    6       3,919 ±     0,026  us/op
SortingAlgorithmBenchmark.quickSort          1000          asc  avgt    6       7,877 ±     0,316  us/op
SortingAlgorithmBenchmark.quickSort          1000         desc  avgt    6       9,659 ±     0,208  us/op
SortingAlgorithmBenchmark.quickSort          1000         rand  avgt    6      55,421 ±     0,253  us/op
SortingAlgorithmBenchmark.quickSort         10000          asc  avgt    6     103,746 ±     2,902  us/op
SortingAlgorithmBenchmark.quickSort         10000         desc  avgt    6     116,523 ±    10,948  us/op
SortingAlgorithmBenchmark.quickSort         10000         rand  avgt    6     761,428 ±    16,176  us/op
```