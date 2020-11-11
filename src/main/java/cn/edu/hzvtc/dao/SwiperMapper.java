package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Swiper;
import java.util.List;

public interface SwiperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Swiper record);

    Swiper selectByPrimaryKey(Integer id);

    List<Swiper> selectAll();

    int updateByPrimaryKey(Swiper record);
}