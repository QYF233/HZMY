package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlateServiceImpl implements PlateService {

    @Autowired
    private PlateMapper plateMapper;

    /**
     * 获取所有导航信息 type = 1
     *
     * @return
     */
    @Override
    public List<Plate> getPlates(boolean pageType) {
        if (pageType) {
            List<Plate> plateList = plateMapper.getPlateByType(2);
            List<Plate> plateList1 = plateMapper.getPlateByType(3);
            plateList.addAll(plateList1);
            return plateList;
        } else {
            return plateMapper.getPlateByType(1);
        }
    }


    /**
     * 获取导航列表
     *
     * @return
     */
    @Override
    public List<Plate> getNavsByParent(Integer parentId) {
        List<Plate> plateList = plateMapper.getNavByParentId(parentId);
        return plateList;
    }

    @Override
    public List<Plate> getNavs() {
        List<Plate> plateList = plateMapper.selectAllNavs();
        return plateList;
    }

    /**
     * 获取导航总数
     *
     * @param plaParentId
     * @return
     */
    @Override
    public int getNavCount(Integer plaParentId) {
        return plateMapper.getNavCount(plaParentId);
    }

    /**
     * 更新导航信息
     *
     * @param nav
     * @return
     */
    @Override
    public int updateNav(Plate nav) {
        return plateMapper.updateNavById(nav);
    }

    /**
     * 获取同一个父导航的导航列表
     *
     * @param parentId 父导航id
     * @return
     */
    @Override
    public List<Plate> selectChildByParentId(Integer parentId) {
        return plateMapper.selectChildByParentId(parentId);
    }

    /**
     * 删除导航
     *
     * @param id
     * @return
     */
    @Override
    public int delNav(Integer id) {
        return plateMapper.deleteById(id);
    }

    /**
     * 添加导航
     *
     * @param plate
     * @return
     */
    @Override
    public int addNav(Plate plate) {
        return plateMapper.insert(plate);
    }

    /**
     * 获取所有板块信息
     *
     * @return
     */
    @Override
    public List<Plate> getSection() {
        List<Plate> plateList = plateMapper.getSection();
        return plateList;
    }

    /**
     * 按id查询板块
     *
     * @param id
     * @return
     */
    @Override
    public Plate getSec(Integer id) {
        return plateMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新板块信息
     *
     * @param plate
     * @return
     */
    @Override
    public int updateSec(Plate plate) {
        return plateMapper.updateSecById(plate);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean delSec(String ids) {
        boolean result = false;
        if (ids.contains("-")) {
            /*批量删除*/
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String strId : strIds) {
                delIds.add(Integer.parseInt(strId));
            }
            if (plateMapper.deleteByIdList(delIds) > 0) {
                result = true;
            }
        } else {
            /*单一删除*/
            Integer id = Integer.parseInt(ids);
            if (plateMapper.selectByPrimaryKey(id) != null) {
                if (plateMapper.deleteById(id) > 0) {

                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * 排序
     *
     * @param newSort     新次序
     * @param oldSort     旧次序
     * @param flag        是导航nav还是板块sec
     * @param plaParentId 父id
     * @return
     */
    @Override
    public int updateSort(Integer newSort, Integer oldSort, String flag, Integer plaParentId) {
        return plateMapper.sort(newSort, oldSort, flag, plaParentId);
    }

    @Override
    public int delSort(Integer id, String flag) {
        return plateMapper.delSort(id, flag);
    }

    @Override
    public Plate getNav(Integer id) {
        return plateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int changePic(Integer id, String plaPic) {
        return plateMapper.changePic(id, plaPic);
    }
}
