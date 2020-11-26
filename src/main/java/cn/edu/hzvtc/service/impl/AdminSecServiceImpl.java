package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AdminSecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSecServiceImpl implements AdminSecService {
    @Autowired
    public PlateMapper plateMapper;

    @Override
    public Long getSecCount() {
        return plateMapper.getSecCount();
    }
}
