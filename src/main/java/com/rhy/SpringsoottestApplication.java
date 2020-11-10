package com.rhy;

import com.rhy.Interceptor.AdminsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

/**
 * 所有内容都配置到application.properties文件内容过多，可以使用：PropertySource
 * value：可以配置多个配置文件，使用classpath前缀，意味着去类目录下找到属性文件
 * ignoreResourceNotFound：则是忽略配置文件找不到的问题，默认值：false 找不到报错，true：找不到忽略
 */
@PropertySource(value = {"classpath:jdbc.properties"},ignoreResourceNotFound = true)
/**
 * 扫描包路径
 */
@SpringBootApplication(scanBasePackages = {"com.rhy.*"})
/**
 * 使用缓存
 */
@EnableCaching
public class SpringsoottestApplication implements WebMvcConfigurer { //如果要使用拦截器必须实现WebMvcConfigurer接口
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(SpringsoottestApplication.class, args);
        //所有的bean
//        String[] beans = applicationContext.getBeanDefinitionNames();
//        for(String bean : beans){
//            System.out.println("bean:"+bean);
//        }
//        SQL sql = (SQL) applicationContext.getBean(SQL.class);
//        sql.SELECT("*").FROM("emp");
//        System.out.println("sql:"+applicationContext.getBean(SQL.class));
    }
    //注入事务管理器，他由Spring boot自动生成
    @Autowired
    PlatformTransactionManager transactionManager;
    //使用后初始化方法，观察自动生成的事务管理器
    @PostConstruct
    public void viewTransactionManager(){
        //启动前加入断点观测
        System.out.println(transactionManager.getClass().getName());

    }

    /**
     * 拦截器注册必须实现的方法 要不然拦截器不好使
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器到spring mvc机制，然后他会返回一个拦截器注册
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new AdminsInterceptor());
        //指定拦截匹配模式，限制拦截器拦截请求
        interceptorRegistration.addPathPatterns("/interceptor/*");
    }
}
