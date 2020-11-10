package com.rhy.Database;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: 检测数据库连接池类型
 * @Version:1.0
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("---------------数据库连接池类型---------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("---------------数据库连接池类型结束---------------");
    }
}
