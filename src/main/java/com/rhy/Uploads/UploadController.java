package com.rhy.Uploads;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: 文件上传
 * @Version:1.0
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    /**
     * 上传页
     */
    @RequestMapping("/page/upload")
    public String uploadPage(){
        return "/uploads";
    }
    /**
     * 多/单文件上传
     * 推荐 ------------------
     * 使用MultipartFile作为参数
     * @param multipartFile 请求参数，文件信息在其中
     * @return 上传结果
     */
    @RequestMapping("/upload/Multipart")
    @ResponseBody
    public Map<String,Object> uploadRequest(@RequestPart("file") MultipartFile[] multipartFiles){ //单文件上传改成MultipartFile multipartFile即可，非数组
        Map<String,Object> res = new HashMap<>();
        if(multipartFiles == null){
            res.put("code",2);
            res.put("msg","没有上传文件");
        }else {
            //获取源数据名称 ----  可以在此指定文件夹路径
            for(int i=0;i<multipartFiles.length;i++){
                MultipartFile multipartFile = multipartFiles[i];
                String fileName = "/uploads/other/"+multipartFile.getOriginalFilename();
                System.out.println(fileName);
                File file = new File(fileName);
                try {
                    multipartFile.transferTo(file);
                    res.put("code", 1);
                    res.put("msg", "上传成功");
                } catch (IOException e) {
                    res.put("code", 2);
                    res.put("msg", "上传失败");
                    System.out.println("上传失败");
                    e.printStackTrace();
                    return res;
                }
            }

        }


        return res;
    }
    /**
     * 使用httpServletRequest作为参数
     * @param request 请求参数，文件信息在其中
     * @return 上传结果
     */
    @RequestMapping("/upload/http")
    @ResponseBody
    public Map<String,Object> uploadRequestHttp(HttpServletRequest request){
        Map<String,Object> res = new HashMap<>();
        boolean flag = false;
        MultipartHttpServletRequest mreq = null;
        //强制转换为MultipartHttpServletRequest接口对象
        if(request instanceof MultipartHttpServletRequest){
            mreq = (MultipartHttpServletRequest) request;
        }else{
            res.put("code",2);
            res.put("msg","没有上传文件");
        }
        //有文件上传对象
        if(mreq != null){
            //获取MultipartFile文件信息
            MultipartFile multipartFile = mreq.getFile("file");//对象上前端文件名
            //获取源数据名称
            String fileName = multipartFile.getOriginalFilename();
            System.out.println(fileName);
            File file = new File(fileName);
            try {
                multipartFile.transferTo(file);
                res.put("code", 1);
                res.put("msg", "上传成功");
            } catch (IOException e) {
                res.put("code",2);
                res.put("msg","上传失败");
                System.out.println("上传失败");
                e.printStackTrace();
            }
        }


        return res;
    }

    /**
     * 使用Part作为参数
     * @param file 请求参数，文件信息在其中
     * @return 上传结果
     */
    @RequestMapping("/upload/part")
    @ResponseBody
    public Map<String,Object> uploadPart(Part file){
        Map<String,Object> res = new HashMap<>();
        //获取提交文件名称
        String fileName = file.getSubmittedFileName();
        System.out.println(fileName);
        try{
            //写入文件
            file.write(fileName);
        } catch (IOException e) {
            res.put("code","2");
            res.put("msg", "上传失败");
            e.printStackTrace();
        }

        return res;
    }
}
