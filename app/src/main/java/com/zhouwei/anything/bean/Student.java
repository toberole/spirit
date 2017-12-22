package com.zhouwei.anything.bean;

import android.content.ContentValues;

import com.zhouwei.anything.xxorm.Saveable;

/**
 * Created by zhouwei on 2017/12/21.
 */

public class Student extends Saveable {
    private String name;
    private int age;
    private int id;

    public Student() {
    }

    private Student(ContentValues values) {
        try {
            setAge(Integer.parseInt(String.valueOf(values.get("age"))));
            setName(String.valueOf(values.get("name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(ContentValues values) {
        super.save(values);
        values.remove("id");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
