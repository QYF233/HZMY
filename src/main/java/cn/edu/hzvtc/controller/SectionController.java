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
import org.springframework.web.bind.annotation.*;
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
    public String UPLOAD_URL = "C:/Program Files/nginx-1.18.0/html/com/";
//    public String UPLOAD_URL = "D:/DEV/nginx-1.18.0/html/com/";
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
        PageHelper.startPage(pn, 8);
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
    @RequestMapping(value = "/uploadImgs",method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg uploadImgs(@RequestParam MultipartFile[] files,
                                @RequestParam("sectionId") Integer sectionId,
                                HttpSession session) {
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            String originalFilename = multipartFile.getOriginalFilename();

//            String filePath = "D:/DEV/nginx-1.18.0/html/com/swiper/";
            File file = new File(UPLOAD_URL +"swiper/"+ originalFilename);

            try {
                multipartFile.transferTo(file.getAbsoluteFile());
                if (plateService.changePic(sectionId, file.getName()) > 0) {
                    return ReturnMsg.success();
                } else {
                    return ReturnMsg.fail().add("errorMsg","错1");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnMsg.fail().add("errorMsg",e.toString());
            }
        }
        return ReturnMsg.fail().add("errorMsg","错3");
    }

}
