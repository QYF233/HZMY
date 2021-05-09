package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AdminSecService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import cn.edu.hzvtc.tools.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 板块管理
 */
@Controller
@RequestMapping("/admin/section")
public class AdminSecController {

    @Value("#{configProperties['UPLOAD_URL']}")
    private String UPLOAD_URL;

    @Autowired
    public PlateService plateService;

    @Autowired
    public AdminSecService adminSecService;

    /**
     * 获取板块列表
     *
     * @return List
     */
    @RequestMapping("/getSection")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSection() {
        List<Plate> sec = plateService.getSection();
        if (sec != null) {
            return ReturnMsg.success().add("sec", sec).add("secCount", sec.size());
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 获取单个数据
     *
     * @param id 板块id
     * @return Plate
     */
    @RequestMapping(value = "/getSec", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSec(@RequestParam("id") Integer id) {
        Plate sec = plateService.getSec(id);
        if (sec != null) {
            return ReturnMsg.success().add("sec", sec);
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 删除
     *
     * @param id 删除id
     * @return
     */
    @RequestMapping(value = "/delSec", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delSec(@RequestParam("id") Integer id) {
        if (plateService.delNav(id) > 0) {
            plateService.delSort(id, "sec");
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
    @RequestMapping(value = "/delSec/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg delSec(@PathVariable("ids") String ids) {
        if (plateService.delSec(ids)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 添加
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/addSec", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addSec(@RequestBody Plate plate) {
        List<Plate> sec = plateService.getSection();
        plate.setPlaParentId(0);
        plate.setPlaSort(sec.size() + 1);
        if (plateService.addNav(plate) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 更新数据
     *
     * @param plate
     * @return
     */
    @RequestMapping(value = "/updateSec", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateSec(@RequestBody Plate plate) {
        Plate oldPlate = plateService.getSec(plate.getId());
        Integer oldSort = oldPlate.getPlaSort();
        /*如果sort有变动，进行排序*/
        if (!oldSort.equals(plate.getPlaSort())) {
            plateService.updateSort(plate.getPlaSort(), oldSort, "sec", 0);
        }
        if (plateService.updateSec(plate) > 0) {
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
        String path = UPLOAD_URL + "/secImg";
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

    @RequestMapping(value = "/delImg", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delImg(@RequestParam("filename") String filename) {
        String path = UPLOAD_URL + "/secImg/";
        File file = new File(path + filename);
        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
            if (plateService.delImg(filename) == 1) {
                return ReturnMsg.success();
            } else {
                return ReturnMsg.fail();
            }
        } else {
            return ReturnMsg.fail();
        }
    }


}
