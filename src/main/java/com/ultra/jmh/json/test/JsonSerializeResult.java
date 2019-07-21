package com.ultra.jmh.json.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ultra.jmh.json.bean.FullName;
import com.ultra.jmh.json.bean.Person;
import com.ultra.jmh.json.utils.FastJsonUtil;
import com.ultra.jmh.json.utils.GsonUtil;
import com.ultra.jmh.json.utils.JacksonUtil;
import com.ultra.jmh.json.utils.JsonLibUtil;

public class JsonSerializeResult {

    public static void main(String[] args) {
        JsonSerializeResult jsonSerializeResult = new JsonSerializeResult();
        Person person = jsonSerializeResult.person();
        System.out.println(FastJsonUtil.bean2Json(person));// 空属性空集合不转化
        System.out.println(GsonUtil.bean2Json(person));// 空属性空集合不转化
        System.out.println(JacksonUtil.bean2Json(person));// 空属性,空集合转null
        System.out.println(JsonLibUtil.bean2Json(person));// 空属性转null,空集合转[]
    }

    public Person person() {
        List<Person> friends = new ArrayList<Person>();
        friends.add(createAPerson("小明", null));
        friends.add(createAPerson("Tony", null));
        friends.add(createAPerson("陈小二", null));
        return createAPerson("邵同学", friends);
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
