package com.ultra.jmh.json.test;

import java.util.concurrent.TimeUnit;

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

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class EqualBenchmark {
    /**
     * 序列化次数参数
     */
    @Param({ "1000", "10000", "100000" })
    private int count;

//          1000            10000           100000
//FastJson  0.202           0.280           0.496
//Gson      0.186           0.349           1.609
//Jackson   0.386           0.507           0.771
//JsonLib   0.587           3.040           9.405
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(EqualBenchmark.class.getSimpleName()).forks(1).warmupIterations(0)
                .build();
        new Runner(opt).run();
        // Collection<RunResult> results = new Runner(opt).run();
        // for (RunResult runResult : results) {
        // Collection<BenchmarkResult> benchmarkResults =
        // runResult.getBenchmarkResults();
        // }
    }

    @Benchmark
    public void lt() {
        for (int i = 0; i < count; i++) {

        }
    }

    @Benchmark
    public void le() {
        for (int i = 1; i <= count + 1; i++) {
        }
    }

}
