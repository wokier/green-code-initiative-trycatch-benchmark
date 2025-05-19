package com.github.wokier.trycatchbench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class NullCheckBenchmark {

    @Benchmark
    public void withTryCatch(Blackhole blackhole){
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            try {
                blackhole.consume(randomlyNull());
            } catch (NullPointerException e) {
                count+=1;
            }
        }
        blackhole.consume(count);
        // System.out.println("null " + count + " times");
    }

    @Benchmark
    public void withIfTest(Blackhole blackhole){
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            Double rnd = randomlyNull();
            if (rnd != null) {
                blackhole.consume(rnd.doubleValue());
            } else {
                count+=1;
            }
        }
        blackhole.consume(count);
        // System.out.println("null " + count + " times");
    }

    private Double randomlyNull(){
        double rnd = Math.random();
        return (rnd< 0.5D) ? null : rnd;
    }

}
