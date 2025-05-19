Run the benchmark from IDE
---
FatJarRunner main

Run the benchmark from console (recommended)
---
$ mvn clean compile assembly:single && java -jar target/green-code-initiative-trycatch-benchmark-jar-with-dependencies.jar -bm avgt -tu ms

Results (Macbook Pro 2020 M1 16Go Sequoia Java amazon-corretto-17) :
Benchmark                        Mode  Cnt  Score    Error  Units
NullCheckBenchmark.withIfTest    avgt   25  0.027 ±  0.001  ms/op
NullCheckBenchmark.withTryCatch  avgt   25  0.029 ±  0.001  ms/op
