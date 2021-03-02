package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;
import cn.edu.hzvtc.service.AdminSwiService;
import cn.edu.hzvtc.service.AnnexService;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 后台文章管理
 */
@Controller
@RequestMapping("/admin/swiper")
public class AdminSwiperController {

    @Autowired
    public ArticleService articleService;

    @Autowired
    public PlateService plateService;

    @Autowired
    public AnnexService annexService;

    @Autowired
    public AdminSwiService adminSwiService;
//    public String UPLOAD_URL = "C:/uploadFile/";
//    public String UPLOAD_URL = "C:/Program Files/nginx-1.18.0/html/com/upload/";
    public String UPLOAD_URL = "D:/DEV/nginx-1.18.0/html/com/upload/";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    /**
     * 获取所有轮播图信息
     *
     * @return
     */
    @RequestMapping("/getSwiper")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSwiper() {
        List<Swiper> swiperList = adminSwiService.getSwiper();
        return ReturnMsg.success().add("swiperList", swiperList);
    }

    /**
     * 根据id获取文章信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/getArticleById")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticleById(@RequestParam("id") Integer id) {
        List<Annex> annexes = new ArrayList<>();
        Article article = articleService.getArticleById(id);
        String fileStr = article.getArtFileId();

        if (fileStr != null && !"".equals(fileStr)) {
            String[] fileList = fileStr.substring(0, fileStr.length() - 1).split("-");
            for (String item : fileList) {
                //逐条获取附件信息
                if (!"".equals(item)) {
                    Annex annex = annexService.getAnnex(Integer.parseInt(item));
                    if (annex != null) {
                        annexes.add(annex);
                    }
                }
            }
        }
        return ReturnMsg.success().add("article", article).add("annexes", annexes);
    }

    /**
     * 获取板块列表
     *
     * @return
     */
    @RequestMapping("/getSec")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSec() {
        List<Plate> plates = plateService.getPlates(true);
        return ReturnMsg.success().add("plates", plates);
    }


    /**
     * 添加文章
     *
     * @param article 文章信息
     * @return
     */
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addArticle(@Valid Article article, @RequestParam(value = "artTimeStr") String artTimeStr) {
//        System.out.println(article.toString());
        if (article.getArtTop() == 1) {
            articleService.cancelTop(article.getArtPlateId());
        }
        try {
            article.setArtTime(simpleDateFormat.parse(artTimeStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (articleService.addArticle(article) > 0) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
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
    public ReturnMsg uploadImgs(@RequestParam MultipartFile[] files, HttpSession session) {
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            String originalFilename = multipartFile.getOriginalFilename();

            //此处文件保存地址应该改为服务器存放数据的地址
            File file = new File(UPLOAD_URL + "imgs/" + originalFilename);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnMsg.fail();
            }
        }
//        System.out.println(files.length);

        return ReturnMsg.success();
    }

    /**
     * 上传文件
     *
     * @param files
     * @param session
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public ReturnMsg uploadFile(@RequestParam MultipartFile[] files, HttpSession session) {
        String annexId = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            String originalFilename = multipartFile.getOriginalFilename();

            //此处文件保存地址应该改为服务器存放数据的地址
            File file = new File(UPLOAD_URL + "files/" + originalFilename);
            try {
                multipartFile.transferTo(file);
                Annex annex = new Annex();
                annex.setFileName(file.getName());
                annex.setFileTime(new Date());
                annex.setFileDown(0);
                String[] s = file.getName().split("\\.");
                //判断文件类型
                if ("pdf".equals(s[1])) {
                    annex.setFileType(0);
                } else if ("doc".equals(s[1])) {
                    annex.setFileType(1);
                } else if ("txt".equals(s[1])) {
                    annex.setFileType(2);
                } else if ("zip".equals(s[1])) {
                    annex.setFileType(3);
                } else {
                    annex.setFileType(-1);
                }
                //写入附件数据库
                if (annexService.addAnnex(annex) == 0) {
                    return ReturnMsg.fail();
                }
                //返回附件id
                annexId += annex.getId() + "-";
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnMsg.fail();
            }
        }

        return ReturnMsg.success().add("annexId", annexId);
    }

    /**
     * 删除文章
     *
     * @param id 文章id
     * @return
     */
    @RequestMapping(value = "/delArt", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delArt(@RequestParam("id") String id) {
        if (articleService.delArt(id)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 批量删除
     *
     * @param ids 删除id列表
     * @return
     */
    @RequestMapping(value = "/delArt/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg delArtAll(@PathVariable("ids") String ids) {
        if (articleService.delArt(ids)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 更新文章
     *
     * @param article    文章
     * @param artTimeStr 时间str
     * @return
     */
    @RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateArticle(@Valid Article article, @RequestParam(value = "artTimeStr") String artTimeStr) {
//        System.out.println(article.toString());
        if (article.getArtTop() == 1) {
            articleService.cancelTop(article.getArtPlateId());
        }
        try {
            //设置时间
            article.setArtTime(simpleDateFormat.parse(artTimeStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (articleService.updateArt(article) > 0) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

}
