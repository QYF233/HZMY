package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Swiper;
import java.util.List;

/**
 * @author kiko
 */
public interface SwiperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Swiper record);

    Swiper selectByPrimaryKey(Integer id);

    List<Swiper> selectAll();

    int updateByPrimaryKey(Swiper record);

    /**
     * 添加图片
     * @param record
     * @return
     */
    int insertSecPic(Swiper record);
}