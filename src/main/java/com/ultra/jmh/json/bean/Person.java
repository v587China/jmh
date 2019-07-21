package com.ultra.jmh.json.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ultra.jmh.json.utils.FastJsonUtil;

public class Person implements Serializable {

    private static final long serialVersionUID = -3660662716117989192L;

    private String name;
    private FullName fullName;
    private int age;
    private Date birthday;
    private List<String> hobbies;
    private Map<String, String> clothes;
    private List<Person> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getClothes() {
        return clothes;
    }

    public void setClothes(Map<String, String> clothes) {
        this.clothes = clothes;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public String toString0() {
        return "Person [name=" + name + ", fullName=" + fullName + ", age=" + age + ", birthday=" + birthday
                + ", hobbies=" + hobbies + ", clothes=" + clothes + ", friends=" + friends + "]";
    }

    public String toString1() {
        return FastJsonUtil.bean2Json(this);
    }

    public int hashCode0() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((clothes == null) ? 0 : clothes.hashCode());
        result = prime * result + ((friends == null) ? 0 : friends.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public int hashCode1() {
        return HashCodeBuilder.reflectionHashCode(this, "birthday", "clothes", "friends", "fullName", "hobbies",
                "name");
    }

    public boolean equals0(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (birthday == null) {
            if (other.birthday != null)
                return false;
        } else if (!birthday.equals(other.birthday))
            return false;
        if (clothes == null) {
            if (other.clothes != null)
                return false;
        } else if (!clothes.equals(other.clothes))
            return false;
        if (friends == null) {
            if (other.friends != null)
                return false;
        } else if (!friends.equals(other.friends))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (hobbies == null) {
            if (other.hobbies != null)
                return false;
        } else if (!hobbies.equals(other.hobbies))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public boolean equals1(Object obj) {

        return EqualsBuilder.reflectionEquals(this, obj, "birthday", "clothes", "friends", "fullName", "hobbies",
                "name");
    }

}
