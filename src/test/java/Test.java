import cn.edu.hzvtc.dao.UserMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.ArticleService;
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
    @Autowired
    public ArticleService articleService;

    @org.junit.Test
    public void test() {
        List<Article> list = articleService.getArticle(1);
        System.out.println(list);
    }
}
