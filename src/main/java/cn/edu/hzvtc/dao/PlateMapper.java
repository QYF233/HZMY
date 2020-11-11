package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Plate;
import java.util.List;

public interface PlateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plate record);

    Plate selectByPrimaryKey(Integer id);

    List<Plate> selectAll();

    int updateByPrimaryKey(Plate record);
}