package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AnnexService;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 后台文章管理
 *
 * @author kiko
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    public ArticleService articleService;

    @Autowired
    public PlateService plateService;

    @Autowired
    public AnnexService annexService;

    @Value("#{configProperties['UPLOAD_URL']}")
    private String UPLOAD_URL;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    /**
     * 获取所有文章，0不分板块，按发布时间
     *
     * @param sectionId
     * @param pn
     * @return
     */
    @RequestMapping("/getArticle")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticle(@RequestParam(value = "sectionId", defaultValue = "0") Integer sectionId,
                                @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                @RequestParam(value = "search", defaultValue = "") String search,
                                @RequestParam("pageType") boolean pageType) {
        PageHelper.startPage(pn, 5);
        List<Article> list = articleService.getArticle(sectionId, search, pageType);
        PageInfo pageInfo = new PageInfo(list, 10);
        return ReturnMsg.success().add("pageInfo", pageInfo);
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
    public ReturnMsg getSec(@RequestParam("pageType") boolean pageType) {
        List<Plate> plates = plateService.getPlates(pageType);
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
        System.out.println(article.toString());
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
        String outName = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = new String[0];
            if (originalFilename != null) {
                //*截取后缀名*//*
                filename = originalFilename.split("\\.");
            }
            Date date = new Date();
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
            filename[0] = sdformat.format(date);
//            String reg = ".+(.JPEG|.jpeg|.JPG|.jpg)$";
//            String imgp = "Redocn_2012100818523401.png";
//            Pattern pattern = Pattern.compile(reg);
//            Matcher matcher = pattern.matcher(imgp);
//            System.out.println(matcher.find());
//            System.out.println(filename[filename.length - 1]);
//            if ("csv".equals(filename[filename.length - 1])) {
//                return ReturnMsg.fail().add("msg", "文件类型不正确");
//            }
            String newFilename = filename[0] + "-" + originalFilename;
            outName += newFilename + "/";
            //此处文件保存地址应该改为服务器存放数据的地址
            File file = new File(UPLOAD_URL + "/upload/imgs/" + newFilename);
            try {
                multipartFile.transferTo(file.getAbsoluteFile());
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnMsg.fail().add("errorMsg", e.toString());
            }
        }
//        System.out.println(files.length);

        return ReturnMsg.success().add("outName", outName);
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
            /*            String[] filename = new String[0];
            if (originalFilename != null) {
                *//*截取后缀名*//*
                filename = originalFilename.split("\\.");
            }
            if ("csv".equals(filename[filename.length - 1])) {
                return ReturnMsg.fail().add("msg", "文件类型不正确");
            }*/
            //此处文件保存地址应该改为服务器存放数据的地址

            File file = new File(UPLOAD_URL + "/upload/files/" + originalFilename);
            try {
                multipartFile.transferTo(file.getAbsoluteFile());
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
                    return ReturnMsg.fail().add("errorMsg", "错1");
                }
                //返回附件id
                annexId += annex.getId() + "-";
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnMsg.fail().add("errorMsg", e.toString());
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
    @RequestMapping(value = "/delArt/{ids}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delArtAll(@PathVariable("ids") String ids) {
        if (articleService.delArt(ids)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail().add("msg", "错");
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
        System.out.println(article.toString());
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

    /**
     * 获取学院简介
     *
     * @return
     */
    @RequestMapping("/getIntro")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getIntro() {
        Article intro = articleService.getIntro();
        return ReturnMsg.success().add("intro", intro);
    }

    /**
     * 获取学院简介
     *
     * @return
     */
    @RequestMapping(value = "/updateIntro", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateIntro(@RequestParam(value = "introText") String introText, @RequestParam(value = "picName") String picName) {
        if (articleService.updateIntro(introText, picName) > 0) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

}
