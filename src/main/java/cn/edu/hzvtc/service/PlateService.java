package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Plate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlateService {
    public List<Plate> getPlates();

    public List<Plate> getNavs();

    public int getNavCount(Integer plaParentId);

    public int updateNav(Plate nav);

    public int updateSort(Integer id,Integer plaSort);

    public List<Plate> selectChildByParentId(Integer parentId);

    public int delNav(Integer id);

    public int addNav(Plate plate);
    public List<Plate> getSection();

    public Plate getSec(Integer id);
}
