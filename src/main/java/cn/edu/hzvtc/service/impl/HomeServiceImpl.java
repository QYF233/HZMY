package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kiko
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    public PlateMapper plateMapper;

    @Override
    public List<Plate> getList() {
        return plateMapper.selectAll();
    }
}
