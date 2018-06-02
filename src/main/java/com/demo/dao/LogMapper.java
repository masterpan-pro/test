package com.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.demo.entity.Log;

@Mapper
public interface LogMapper {
    int insert(@Param("log") Log log);

    int insertSelective(@Param("log") Log log);

    int insertList(@Param("logs") List<Log> logs);

    int update(@Param("log") Log log);

    List<Log> find();
}
