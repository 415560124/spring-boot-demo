package com.rhy.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/15
 * @Description:
 * 如果您需要在启动后运行某些特定代码SpringApplication，
 * 则可以实现ApplicationRunner或CommandLineRunner接口。
 * 两个接口以相同的方式工作并提供单个run方法，该方法在SpringApplication.run(…​)完成之前调用 。
 * 所述CommandLineRunner接口提供访问的应用程序的参数作为一个简单的字符串数组，
 * 而ApplicationRunner使用了ApplicationArguments前面所讨论的接口。
 * 以下示例显示了CommandLineRunner一个run方法：
 * @Version:1.0
 */
@Component
public class MyBean2 implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner : ok!");
    }
}
