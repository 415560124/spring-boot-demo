package com.rhy.ExitCodeApplication;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/15
 * @Description:
 * 每个都SpringApplication注册一个与JVM的关闭钩子，
 * 以确保 ApplicationContext在退出时正常关闭。
 * 可以使用所有标准的Spring生命周期回调（例如DisposableBean接口或@PreDestroy注释）。
 *
 * 此外，org.springframework.boot.ExitCodeGenerator 如果bean
 * 在SpringApplication.exit()调用时希望返回特定的退出代码，则可以实现该接口。
 * 然后可以传递此退出代码System.exit()以将其作为状态代码返回，如以下示例所示：
 * @Version:1.0
 */
public class ExutCodeApplication {
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        return ()->{
            return 42;
        };
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(ExutCodeApplication.class,args)));
    }
}
