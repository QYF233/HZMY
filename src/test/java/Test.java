import cn.edu.hzvtc.dao.AnnexMapper;
import cn.edu.hzvtc.dao.UserMapper;
import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {

    @Autowired
    public PlateService plateService;
    @Autowired
    public ArticleService articleService;
    @Autowired
    private AnnexMapper annexMapper;

    @org.junit.Test
    public void test() {
        Annex annex = new Annex("11223sdds", new Date(), 1, 1);
        int a =  annexMapper.insert(annex);
        System.out.println(annex.getId());
    }
}
