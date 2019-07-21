package com.ultra.jmh.json.test;

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

import com.ultra.jmh.json.bean.Person;
import com.ultra.jmh.json.utils.FastJsonUtil;
import com.ultra.jmh.json.utils.GsonUtil;
import com.ultra.jmh.json.utils.JacksonUtil;
import com.ultra.jmh.json.utils.JsonLibUtil;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonDeserializeBenchmark {
    /**
     * 反序列化次数参数
     */
    @Param({ "1000", "10000", "100000" })
    private int count;

    private String jsonStr;

//             1000            10000           100000
//FastJson     0.341           0.463           1.166
//Gson         0.159           0.293           0.930
//Jackson      0.386           0.507           1.059
//JsonLib      1.161           3.374           27.389
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(JsonDeserializeBenchmark.class.getSimpleName()).forks(1)
                .warmupIterations(0).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void JsonLib() {
        for (int i = 0; i < count; i++) {
            JsonLibUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Benchmark
    public void Gson() {
        for (int i = 0; i < count; i++) {
            GsonUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Benchmark
    public void FastJson() {
        for (int i = 0; i < count; i++) {
            FastJsonUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Benchmark
    public void Jackson() {
        for (int i = 0; i < count; i++) {
            JacksonUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Setup
    public void prepare() {
        jsonStr = "{\"name\":\"邵同学\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":[{\"name\":\"小明\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"Tony\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"陈小二\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null}]}";
    }

    @TearDown
    public void shutdown() {
    }
}