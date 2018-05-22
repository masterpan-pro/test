package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private Timestamp birthday;
    private String remark;
    private BigDecimal money;
}
