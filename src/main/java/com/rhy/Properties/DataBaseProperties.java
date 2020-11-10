package com.rhy.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/27
 * @Description: 从配置文件中加载bean属性值
 * @Version:1.0
 */
@Component
@ConfigurationProperties("database")
public class DataBaseProperties {
    private String driverName;
    private String url;
    private String username;
    private String password;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
