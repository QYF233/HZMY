import cn.edu.hzvtc.dao.AnnexMapper;
import cn.edu.hzvtc.dao.UserMapper;
import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {

    @Autowired
    public PlateService plateService;
    @Autowired
    public ArticleService articleService;
    @Autowired
    private AnnexMapper annexMapper;
    @Value("${UPLOAD_URL}")
    public String UPLOAD_URL;

    @org.junit.Test
    public void test() {
//        plateService.delSort(8,"nav");
        Plate nav = plateService.getNav(9);
        String parentId = String.valueOf(nav.getPlaParentId());
        System.out.println(parentId);
        if (parentId.equals("null")){
            plateService.delSort(9, "navRoot");
        }else {
            plateService.delSort(9, "nav");
        }
    }

    @org.junit.Test
    public void test2(){
        System.out.println(UPLOAD_URL);
    }
}
