package Informal.Spring.Non_annotation.Service.Impl;

import Informal.Spring.Non_annotation.Service.Service;

import java.util.*;

public class ServiceImpl implements Service {
    private String[] school;
    private List<String> name;
    private Set<Integer> age;
    private Map<String,String> hobby;
    private Properties sports;

    @Override
    public String toString() {
        return "{school=" + Arrays.toString(school) +
                '}';
    }

    public void setSchool(String[] school) {
        this.school = school;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public void setAge(Set<Integer> age) {
        this.age = age;
    }

    public void setHobby(Map<String, String> hobby) {
        this.hobby = hobby;
    }

    public void setSports(Properties sports) {
        this.sports = sports;
    }
    public void outputAll(){
        System.out.println(toString());
        System.out.println(name);
        System.out.println(age);
        System.out.println(hobby);
        System.out.println(sports);
    }
}
