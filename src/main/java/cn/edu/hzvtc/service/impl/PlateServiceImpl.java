package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateServiceImpl implements PlateService {

    @Autowired
    private PlateMapper plateMapper;

    /**
     * 获取板块
     *
     * @return 板块id
     */
    @Override
    public List<Plate> getPlates() {
        List<Plate> plateList = plateMapper.getPlateByType(2);
        List<Plate> plateList1 = plateMapper.getPlateByType(3);
        plateList.addAll(plateList1);
        return plateList;
    }
    @Override
    public List<Plate> getSection() {
        List<Plate> plateList = plateMapper.getPlateByType(2);
        List<Plate> plateList1 = plateMapper.getPlateByType(4);
        plateList.addAll(plateList1);
        return plateList;
    }
    @Override
    public List<Plate> getNavs() {
        List<Plate> plateList = plateMapper.getPlateByType(1);
        return plateList;
    }

    @Override
    public int getNavCount(Integer plaParentId) {
        return plateMapper.getNavCount(plaParentId);
    }

    @Override
    public int updateNav(Plate nav) {
        return plateMapper.updateNavById(nav);
    }

    @Override
    public int updateSort(Integer id, Integer plaSort) {
        return plateMapper.updateSort(id,plaSort);
    }

    @Override
    public List<Plate> selectChildByParentId(Integer parentId) {
        return plateMapper.selectChildByParentId(parentId);
    }

    @Override
    public int delNav(Integer id) {
        return plateMapper.deleteById(id);
    }

    @Override
    public int addNav(Plate plate) {
        return plateMapper.insert(plate);
    }

    @Override
    public Plate getSec(Integer id) {
        return plateMapper.selectByPrimaryKey(id);
    }
}
