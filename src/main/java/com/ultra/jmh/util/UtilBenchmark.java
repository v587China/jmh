package com.ultra.jmh.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode({ Mode.SingleShotTime })
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.SECONDS)
public class UtilBenchmark {
    @Param({ "1000", "10000", "100000" })
    private int count;
    private List<String> list = new ArrayList<>();

    @Benchmark
    public void util() {
        for (int i = 0; i < count; i++) {
            if (CollectionUtils.isEmpty(list)) {

            }
        }
    }

    @Benchmark
    public void my() {
        for (int i = 0; i < count; i++) {
            if (list == null || list.isEmpty()) {

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(UtilBenchmark.class.getSimpleName()).forks(1).warmupIterations(0)
                .build();
        new Runner(opt).run();
    }
}
