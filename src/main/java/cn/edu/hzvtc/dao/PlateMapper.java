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
    int getSecCount();

    /**
     * 获取所有板块
     *
     * @return
     */
    List<Plate> getPlateByType(Integer typeId);

    /**
     * 获取所有的板块列表
     *
     * @return
     */
    List<Plate> getSection();

    /**
     * 获取父导航的个数
     *
     * @param plaParentId
     * @return
     */
    int getNavCount(Integer plaParentId);

    /**
     * 按id更新导航信息
     *
     * @param nav
     * @return
     */
    int updateNavById(Plate nav);

    /**
     * 更新单条数据的sort
     *
     * @param id
     * @param plaSort
     * @return
     */
    int updateSort(@Param("id") Integer id, @Param("plaSort") Integer plaSort);

    /**
     * 排序，将原本后面的数往前挪
     *
     * @param newSort
     * @param oldSort
     * @return
     */
    int sort(@Param("newSort") Integer newSort,
             @Param("oldSort") Integer oldSort,
             @Param("flag") String flag,
             @Param("plaParentId") Integer plaParentId);


    int deleteById(Integer id);

    int updateSecById(Plate sec);

    int deleteByIdList(List<Integer> ids);
}