package com.demo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Person {

    private Long id;
    private String name;
    private Integer age;
    private String address;
    private Timestamp birthday;
    private String remark;
    private BigDecimal money;

    public Person(String name, Integer age, String address, Timestamp birthday, String remark, BigDecimal money) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.remark = remark;
        this.money = money;
    }

    public Person(String name, Integer age, String address, Timestamp birthday, String remark) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
