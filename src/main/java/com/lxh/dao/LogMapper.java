package com.lxh.dao;

import com.lxh.entity.SysLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
    void saveLog(SysLog log);
}
