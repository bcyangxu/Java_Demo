package com.hbnu.pojo;

public class User {
    private String sno;
    private String pwd;
    private String name;
    private int age;
    private String sex;

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
