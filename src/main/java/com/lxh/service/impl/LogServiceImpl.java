package com.lxh.service.impl;

import com.lxh.dao.LogMapper;
import com.lxh.entity.SysLog;
import com.lxh.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logDao;
    @Override
    public void saveLog(SysLog sysLog) {
        logDao.saveLog(sysLog);
    }
}
