package com.ultra.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode({ Mode.SingleShotTime })
//Throughput:整体吞吐量，例如“1秒内可以执行多少次调用”。
//AverageTime:调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
//SampleTime:随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
//SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
//ALL:以上所有
@State(Scope.Benchmark)
//Scope.Thread:默认的State，每个测试线程分配一个实例
//Scope.Benchmark:所有测试线程共享一个实例，用于测试有状态实例在多线程共享下的性能
//Scope.Group:每个线程组共享一个实例
@OutputTimeUnit(TimeUnit.SECONDS)
public class BenchmarkDemo {

    /**
     * @Param 用来指定某项参数的多种情况,特别适合用来测试一个函数在不同的参数输入的情况下的性能;
     * @Param 注解接收一个String数组，在@setup方法执行前转化为为对应的数据类型。
     *        多个@Param注解的成员之间是乘积关系，譬如有两个用@Param注解的字段，
     *        第一个有5个值，第二个字段有2个值，那么每个测试方法会跑5*2=10次。
     */
    @Param({ "10", "20" })
    private int count;
    @Param({ "1", "2" })
    private int num;

    /**
     * 
     * @Benchmark 需要进行 benchmark 的对象
     *
     */
    @Benchmark
    public void JsonLib() {
        for (int i = 0; i < count * num; i++) {
            // System.out.println(i);
        }
    }

    /**
     * 
     * @Setup 在执行 benchmark 之前被执行，主要用于初始化
     *
     */
    @Setup
    public void prepare() {
    }

    /**
     * 
     * @TearDown 在所有 benchmark 执行结束以后执行，主要用于资源的回收等
     *
     */
    @TearDown
    public void shutdown() {
    }

    public static void main(String[] args) throws Exception {
        // forks:执行次数
        // warmupIterations方法预热
        Options opt = new OptionsBuilder().include(BenchmarkDemo.class.getSimpleName()).forks(1).warmupIterations(0)
                .build();
        new Runner(opt).run();
    }
}
