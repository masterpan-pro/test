package com.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.demo.entity.Log;
import com.demo.dao.LogMapper;
import com.demo.service.LogService;

@Service
public class LogServiceImpl implements LogService{

    @Resource
    private LogMapper logMapper;

    @Override
    public int insert(Log log){
        return logMapper.insert(log);
    }

    @Override
    public int insertSelective(Log log){
        return logMapper.insertSelective(log);
    }

    @Override
    public int insertList(List<Log> logs){
        return logMapper.insertList(logs);
    }

    @Override
    public int update(Log log){
        return logMapper.update(log);
    }

    @Override
    public List<Log> find() {
        return logMapper.find();
    }
}
