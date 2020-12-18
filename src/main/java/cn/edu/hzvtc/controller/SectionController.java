package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.dao.SwiperMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.HomeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 前台文章列表
 */
@Controller
@RequestMapping("/section")
public class SectionController {
    @Autowired
    public ArticleService articleService;
    @Autowired
    public HomeService homeService;
    @Autowired
    public PlateService plateService;

    /**
     * 前台列表页，获取当前板块所属文章
     *
     * @param sectionId 板块id
     * @param pn        页码
     * @return 文章列表
     */
    @RequestMapping("/getSection")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticle(@RequestParam("sectionId") Integer sectionId,
                                @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Article> list = homeService.getArticle(sectionId, "all");
        PageInfo pageInfo = new PageInfo(list, 10);
        return ReturnMsg.success().add("pageInfo", pageInfo);
    }

    /**
     * 上传图片
     *
     * @param files
     * @param session
     * @return
     */
    @RequestMapping("/uploadImgs")
    @ResponseBody
    public ReturnMsg uploadImgs(@RequestParam MultipartFile[] files,
                                @RequestParam("sectionId") Integer sectionId,
                                HttpSession session) {
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            String originalFilename = multipartFile.getOriginalFilename();
            //此处文件保存地址应该改为服务器存放数据的地址
            File file = new File("D:/DEV/nginx-1.18.0/html/com/swiper/" + originalFilename);
            try {
                multipartFile.transferTo(file);
                if (plateService.changePic(sectionId, file.getName()) > 0) {
                    return ReturnMsg.success();
                } else {
                    return ReturnMsg.fail();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnMsg.fail();
            }
        }
        return ReturnMsg.fail();
    }

}
