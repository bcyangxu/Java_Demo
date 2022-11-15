package com.hbnu.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class User {
    @ExcelProperty("学号")
    private String sno;
    @ExcelIgnore
    private String pwd;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("年龄")
    private int age;
    @ExcelProperty("性别")
    private String sex;
    @ExcelIgnore
    private int type;

    public User() {
    }

    public User(String sno, String name, int age, String sex, int type) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.type = type;
    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String sno, String pwd, String name, int age, String sex, int type) {
        this.sno = sno;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.type = type;
    }

    public User(String sno, String pwd, String name, int age, String sex) {
        this.sno = sno;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String sno, String name, int age, String sex) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
