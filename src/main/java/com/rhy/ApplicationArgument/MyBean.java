package com.rhy.ApplicationArgument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/15
 * @Description:
 * 如果需要访问传递给的应用程序参数，
 * SpringApplication.run(…​)可以注入 org.springframework.boot.ApplicationArgumentsbean。
 * 该ApplicationArguments 接口提供对原始String[]参数以及解析option 和non-option参数的访问，
 * 如以下示例所示
 * @Version:1.0
 */
@Component
public class MyBean {
    @Autowired
    public MyBean(ApplicationArguments arguments){
        boolean debug = arguments.containsOption("debug");
        List<String> files = arguments.getNonOptionArgs();
        //如果使用“--debug logfile.txt”运行debug = true，files = [“logfile.txt”]
    }
}
