package com.demo.service;

import java.util.List;
import com.demo.entity.Log;
public interface LogService{

    int insert(Log log);

    int insertSelective(Log log);

    int insertList(List<Log> logs);

    int update(Log log);

    List<Log> find();
}
