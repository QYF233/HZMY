package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Plate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlateService {
    public List<Plate> getPlates(boolean pageType);

    /**
     * 获取所有导航信息 type = 1
     *
     * @return
     */
    public List<Plate> getNavs();
    public List<Plate> getNavsByParent(Integer parentId);
    /**
     * 获取导航总数
     *
     * @param plaParentId
     * @return
     */
    public int getNavCount(Integer plaParentId);

    /**
     * 更新导航信息
     *
     * @param nav
     * @return
     */
    public int updateNav(Plate nav);

    /**
     * 获取同一个父导航的导航列表
     *
     * @param parentId
     * @return
     */
    public List<Plate> selectChildByParentId(Integer parentId);

    /**
     * 删除导航
     *
     * @param id
     * @return
     */
    public int delNav(Integer id);

    /**
     * 添加导航
     *
     * @param plate
     * @return
     */
    public int addNav(Plate plate);

    /**
     * 获取所有板块信息
     *
     * @return
     */
    public List<Plate> getSection();

    /**
     * 按id查询板块
     *
     * @param id
     * @return
     */
    public Plate getSec(Integer id);

    /**
     * 更新板块信息
     *
     * @param plate
     * @return
     */
    public int updateSec(Plate plate);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Boolean delSec(String ids);

    /**
     * 排序
     *
     * @param newSort     新次序
     * @param oldSort     旧次序
     * @param flag        是导航nav还是板块sec
     * @param plaParentId 父id
     * @return
     */
    int updateSort(Integer newSort, Integer oldSort, String flag, Integer plaParentId);

    /**
     * 删除排序
     *
     * @param id
     * @param flag
     * @return
     */
    int delSort(Integer id, String flag);

    Plate getNav(Integer id);

    /**
     * 修改图片
     *
     * @param id
     * @param plaPic
     * @return
     */
     int changePic(Integer id, String plaPic);

     int delImg(String filename);
}
