package com.honaf.honaf_db;

import java.util.ArrayList;

/**
 * Created by honaf on 2017/3/14.
 */

public class Developer {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String COMPANY = "company";
    public static final String SKILLS = "skills";


    private String id;
    private String name;
    private int age;
    private ArrayList<Skill> skills;
    private Company company;

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                ", company=" + company +
                '}';
    }
}
