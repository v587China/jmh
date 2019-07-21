package com.ultra.jmh.json.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.ultra.jmh.json.bean.FullName;
import com.ultra.jmh.json.bean.Person;
import com.ultra.jmh.json.utils.FastJsonUtil;
import com.ultra.jmh.json.utils.GsonUtil;
import com.ultra.jmh.json.utils.JacksonUtil;
import com.ultra.jmh.json.utils.JsonLibUtil;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonSerializeBenchmark {
    /**
     * 序列化次数参数
     */
    @Param({ "1000", "10000", "100000" })
    private int count;

    private Person p;

//          1000            10000           100000
//FastJson  0.202           0.280           0.496
//Gson      0.186           0.349           1.609
//Jackson   0.386           0.507           0.771
//JsonLib   0.587           3.040           9.405
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(JsonSerializeBenchmark.class.getSimpleName()).forks(1)
                .warmupIterations(0).build();
        new Runner(opt).run();
        // Collection<RunResult> results = new Runner(opt).run();
        // for (RunResult runResult : results) {
        // Collection<BenchmarkResult> benchmarkResults =
        // runResult.getBenchmarkResults();
        // }
    }

    @Benchmark
    public void JsonLib() {
        for (int i = 0; i < count; i++) {
            JsonLibUtil.bean2Json(p);
        }
    }

    @Benchmark
    public void Gson() {
        for (int i = 0; i < count; i++) {
            GsonUtil.bean2Json(p);
        }
    }

    @Benchmark
    public void FastJson() {
        for (int i = 0; i < count; i++) {
            FastJsonUtil.bean2Json(p);
        }
    }

    @Benchmark
    public void Jackson() {
        for (int i = 0; i < count; i++) {
            JacksonUtil.bean2Json(p);
        }
    }

    @Setup
    public void prepare() {
        List<Person> friends = new ArrayList<Person>();
        friends.add(createAPerson("小明", null));
        friends.add(createAPerson("Tony", null));
        friends.add(createAPerson("陈小二", null));
        p = createAPerson("邵同学", friends);
    }

    @TearDown
    public void shutdown() {
    }

    private Person createAPerson(String name, List<Person> friends) {
        Person newPerson = new Person();
        newPerson.setName(name);
        newPerson.setFullName(new FullName("zjj_first", "zjj_middle", "zjj_last"));
        newPerson.setAge(24);
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("篮球");
        hobbies.add("游泳");
        hobbies.add("coding");
        newPerson.setHobbies(hobbies);
        Map<String, String> clothes = new HashMap<String, String>();
        clothes.put("coat", "Nike");
        clothes.put("trousers", "adidas");
        clothes.put("shoes", "安踏");
        newPerson.setClothes(clothes);
        newPerson.setFriends(friends);
        return newPerson;
    }
}
