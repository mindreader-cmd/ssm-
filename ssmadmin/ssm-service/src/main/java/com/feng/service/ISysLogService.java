package com.feng.service;

import com.feng.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    List<SysLog> findAll();

    void save(SysLog sysLog);
}
