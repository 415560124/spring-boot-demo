package com.rhy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: 视图控制器
 * @Version:1.0
 */
@Controller  //必须为Controller
@RequestMapping("/html")
public class HtmlController {
    /**
     * 本地访问内容地址 ：http://localhost:8088/springboot/html/index
     * @param map 发送给界面的数据
     * @return 静态页文件名
     */
    @RequestMapping("/index")
    public String index(HashMap<String, Object> map){
        map.put("hello", "欢迎进入HTML页面");
        return "index";
    }
}
