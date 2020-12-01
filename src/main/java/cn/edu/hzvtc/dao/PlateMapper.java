package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Plate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kiko
 */
public interface PlateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plate record);

    Plate selectByPrimaryKey(Integer id);

    List<Plate> selectChildByParentId(Integer id);

    List<Plate> selectAll();

    int updateByPrimaryKey(Plate record);

    /**
     * 获取板块数
     *
     * @return 板块数
     */
    Long getSecCount();

    /**
     * 获取所有板块
     *
     * @return
     */
    List<Plate> getPlateByType(Integer typeId);

    /**
     * 获取父导航的个数
     *
     * @param plaParentId
     * @return
     */
    int getNavCount(Integer plaParentId);

    int updateNavById(Plate nav);

    int updateSort(@Param("id") Integer id, @Param("plaSort") Integer plaSort);

    int deleteById(Integer id);

    int updateSecById(Plate sec);

    int deleteByIdList(List<Integer> ids);
}