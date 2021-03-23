package com.feng.service.impl;

import com.feng.dao.SysLogDao;
import com.feng.domain.SysLog;
import com.feng.service.ISysLogService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    SysLogDao sysLogDao;
    public List<SysLog> findAll() {
       return sysLogDao.findAll();

    }
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
