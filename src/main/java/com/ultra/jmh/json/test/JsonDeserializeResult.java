package com.ultra.jmh.json.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.ultra.jmh.json.bean.FullName;
import com.ultra.jmh.json.bean.Person;
import com.ultra.jmh.json.utils.FastJsonUtil;
import com.ultra.jmh.json.utils.GsonUtil;
import com.ultra.jmh.json.utils.JacksonUtil;
import com.ultra.jmh.json.utils.JsonLibUtil;

public class JsonDeserializeResult {
    private static final String fastJsonStr = "{\"age\":24,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[{\"age\":24,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"小明\"},{\"age\":24,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"Tony\"},{\"age\":24,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"陈小二\"}],\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"邵同学\"}";
    private static final String gsonStr = "{\"name\":\"邵同学\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[{\"name\":\"小明\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"}},{\"name\":\"Tony\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"}},{\"name\":\"陈小二\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"}}]}";
    private static final String jackJsonStr = "{\"name\":\"邵同学\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[{\"name\":\"小明\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":null},{\"name\":\"Tony\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":null},{\"name\":\"陈小二\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":null}]}";
    private static final String jsonLibStr = "{\"age\":24,\"birthday\":null,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[{\"age\":24,\"birthday\":null,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[],\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"小明\"},{\"age\":24,\"birthday\":null,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[],\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"Tony\"},{\"age\":24,\"birthday\":null,\"clothes\":{\"coat\":\"Nike\",\"trousers\":\"adidas\",\"shoes\":\"安踏\"},\"friends\":[],\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"陈小二\"}],\"fullName\":{\"firstName\":\"zjj_first\",\"lastName\":\"zjj_last\",\"middleName\":\"zjj_middle\"},\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"name\":\"邵同学\"}";

    public static void main(String[] args) {

        Person fastPerson1 = FastJsonUtil.json2Bean(fastJsonStr, Person.class);
        print(fastPerson1);
        Person fastPerson2 = FastJsonUtil.json2Bean(gsonStr, Person.class);
        print(fastPerson2);
        Person fastPerson3 = FastJsonUtil.json2Bean(jackJsonStr, Person.class);
        print(fastPerson3);
        Person fastPerson4 = FastJsonUtil.json2Bean(jsonLibStr, Person.class);
        print(fastPerson4);
        System.out.println("-------------------FastJsonUtil---------------------------");

        Person gsonPerson1 = GsonUtil.json2Bean(fastJsonStr, Person.class);
        print(gsonPerson1);
        Person gsonPerson2 = GsonUtil.json2Bean(gsonStr, Person.class);
        print(gsonPerson2);
        Person gsonPerson3 = GsonUtil.json2Bean(jackJsonStr, Person.class);
        print(gsonPerson3);
        Person gsonPerson4 = GsonUtil.json2Bean(jsonLibStr, Person.class);
        print(gsonPerson4);
        System.out.println("-------------------GsonUtil---------------------------");

        Person jackJsonPerson1 = JacksonUtil.json2Bean(fastJsonStr, Person.class);
        print(jackJsonPerson1);
        Person jackJsonPerson2 = JacksonUtil.json2Bean(gsonStr, Person.class);
        print(jackJsonPerson2);
        Person jackJsonPerson3 = JacksonUtil.json2Bean(jackJsonStr, Person.class);
        print(jackJsonPerson3);
        Person jackJsonPerson4 = JacksonUtil.json2Bean(jsonLibStr, Person.class);
        print(jackJsonPerson4);
        System.out.println("-------------------JacksonUtil---------------------------");

        Map<String, Class<?>> map = new HashMap<>();
        map.put("friends", Person.class);
        Person jsonLibPerson1 = JsonLibUtil.json2Bean(fastJsonStr, Person.class, map);
        print(jsonLibPerson1);
        Person jsonLibPerson2 = JsonLibUtil.json2Bean(gsonStr, Person.class, map);
        print(jsonLibPerson2);
        Person jsonLibPerson3 = JsonLibUtil.json2Bean(jackJsonStr, Person.class, map);
        print(jsonLibPerson3);
        Person jsonLibPerson4 = JsonLibUtil.json2Bean(jsonLibStr, Person.class, map);
        print(jsonLibPerson4);
        System.out.println("-------------------JsonLibUtil---------------------------");
    }

    private static void print(Person person) {
        System.out.println("Age:" + person.getAge());
        System.out.println("Name:" + person.getName());
        System.out.println("Birthday:" + person.getBirthday());
        Map<String, String> clothes = person.getClothes();
        if (MapUtils.isNotEmpty(clothes)) {
            for (Entry<String, String> entry : clothes.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
        }
        List<String> hobbies = person.getHobbies();
        if (CollectionUtils.isNotEmpty(hobbies)) {
            for (String hobby : hobbies) {
                System.out.println(hobby);
            }
        }
        List<Person> friends = person.getFriends();
        if (CollectionUtils.isNotEmpty(friends)) {
            for (Person person2 : friends) {
                print(person2);
            }
        }
        FullName fullName = person.getFullName();
        System.out.println(fullName.getFirstName());
        System.out.println(fullName.getMiddleName());
        System.out.println(fullName.getLastName());
    }
}
