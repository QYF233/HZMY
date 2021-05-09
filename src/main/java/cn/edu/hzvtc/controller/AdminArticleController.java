package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AnnexService;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import cn.edu.hzvtc.tools.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
                                @RequestParam(value = "title", defaultValue = "") String title,
                                @RequestParam("pageType") boolean pageType,
                                @RequestParam(value = "limit", defaultValue = "5") Integer limit
    ) {
        PageHelper.startPage(pn, limit);
        List<Article> list = articleService.getArticle(sectionId, title, pageType);
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
    public ReturnMsg addArticle(@RequestBody Article article) {
        System.out.println(article.toString());

        if (article.getArtTop() == 1) {
            articleService.cancelTop(article.getArtPlateId());
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
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg imgUpload(MultipartFile file, HttpServletRequest request) {

        //获取文件在服务器的储存位置
//        String path = request.getSession().getServletContext().getRealPath("/upload");
        String path = UPLOAD_URL + "/artImg";
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + filePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在");
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFilename = file.getOriginalFilename();
        System.out.println("原始文件的名称是：" + originalFilename);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //生成随机
        String date = sdf.format(d);
        Util util = new Util();
        String randomString = util.getStringRandom(1);
        System.out.println("生成随机数：" + randomString);
        String fileName = date + randomString + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        //将文件保存到服务器指定位置
        ReturnMsg returnMsg = null;
        try {
            file.transferTo(targetFile);
            System.out.println("上传成功");
            returnMsg = ReturnMsg.success();
            returnMsg.setMessage("上传成功");
            returnMsg.add("newFileName", fileName);
            //将文件在服务器的存储路径返回
            return returnMsg;
        } catch (IOException e) {
            System.out.println("上传失败");
            returnMsg = ReturnMsg.success();
            returnMsg.setMessage("上传失败");
            e.printStackTrace();
            return returnMsg;
        }

    }

    /**
     * 上传附件
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg fileUpload(MultipartFile file, HttpServletRequest request) {
        Annex annex = new Annex();

        annex.setFileDown(0);
        //获取文件在服务器的储存位置
//        String path = request.getSession().getServletContext().getRealPath("/upload");
        String path = UPLOAD_URL + "/artFile";
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + filePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在");
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFilename = file.getOriginalFilename();
        System.out.println("原始文件的名称是：" + originalFilename);
        annex.setFileName(originalFilename);
        //获取文件类型，以最后一个`.`为标识
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        annex.setFileType(type);
        //获取文件名称（不包含格式）
        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        annex.setFileTime(d);
        //生成随机
        String date = sdf.format(d);
        Util util = new Util();
        String randomString = util.getStringRandom(1);
        System.out.println("生成随机数：" + randomString);
        String fileName = date + randomString + "." + type;
        System.out.println("新文件名称：" + fileName);
        annex.setFileRealName(fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        //将文件保存到服务器指定位置
        ReturnMsg returnMsg = null;
        try {
            file.transferTo(targetFile);
            System.out.println("上传成功");
            System.out.println(annex.toString());
            annexService.addAnnex(annex);

            System.out.println(annex.getId());
            returnMsg = ReturnMsg.success();
            returnMsg.setMessage("上传成功");
            returnMsg.add("newFileName", fileName);
            returnMsg.add("fileId",annex.getId());
            //将文件在服务器的存储路径返回
            return returnMsg;
        } catch (IOException e) {
            System.out.println("上传失败");
            returnMsg = ReturnMsg.success();
            returnMsg.setMessage("上传失败");
            e.printStackTrace();
            return returnMsg;
        }

    }

    @RequestMapping(value = "/delImg", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delImg(@RequestParam("filename") String filename) {
        String path = UPLOAD_URL + "/artFile/";
        File file = new File(path + filename);
        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
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

    @RequestMapping(value = "/modifyStatus", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg modifyStatus(@RequestParam(value = "status") String status,
                                  @RequestParam(value = "id") Integer id) {
        if (articleService.updateStatus(status, id) > 0) {
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
