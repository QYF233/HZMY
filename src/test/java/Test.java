import cn.edu.hzvtc.dao.UserMapper;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.PlateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {

    @Autowired
    public PlateService plateService;
    @org.junit.Test
    public void test() {
        List<Plate> sortList = plateService.selectChildByParentId(10);
        System.out.println(sortList);
    }
}
