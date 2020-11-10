package com.rhy.LazyInit.Lazy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description:
 * 不仅仅测试延迟加载
 * 还有bean的生命周期
 * @Version:1.0
 */
@Component                                   //bean名称       bean工厂               App上下文             初始化bean           销毁bean
public class PersonImpl implements Person, BeanNameAware,BeanFactoryAware , ApplicationContextAware , InitializingBean , DisposableBean {
    //@Autowired
    //@Qualifier("dogImpl")
    private Animal animal;

    @Override
    public void service() {
        this.animal.use();
    }
    @Autowired
    @Qualifier("dogImpl")
    public void setAnimal(Animal animal){
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    /***********生命周期监控***********/
    //第一个初始化bean容器时
    @Override
    public void setBeanName(String beanName){
        System.out.println("【"+this.getClass().getSimpleName()+"】调用beanNameAware的setBeanName");
    }

    //初始化bean工厂时
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用beanFactoryAware的setBeanFactory");
    }

    //App上下文创建
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用ApplicationContext的setApplicationContext");
    }

    //自定义标注方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用InitializingBean的afterPropertiesSet");
    }

    //销毁bean
    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】DisposableBean方法的Destroy");
    }



}
