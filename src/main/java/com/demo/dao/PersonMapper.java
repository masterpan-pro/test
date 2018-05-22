package com.demo.dao;

import com.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {
    int insert(@Param("person") Person person);

    int insertSelective(@Param("person") Person person);

    int insertList(@Param("persons") List<Person> persons);

    int update(@Param("person") Person person);

    Person findById(@Param("id") Long id);

    List<Person> find();

    Person findByIdAndNameAndAddress(@Param("id") Long id, @Param("name") String name, @Param("address") String address);

}
