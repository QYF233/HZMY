package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.dao.SwiperMapper;
import cn.edu.hzvtc.pojo.Swiper;
import cn.edu.hzvtc.service.AdminSecService;
import cn.edu.hzvtc.service.AdminSwiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSwiServiceImpl implements AdminSwiService {
    @Autowired
    public SwiperMapper swiperMapper;

    @Override
    public List<Swiper> getSwiper() {
        return swiperMapper.selectAll();
    }
}
