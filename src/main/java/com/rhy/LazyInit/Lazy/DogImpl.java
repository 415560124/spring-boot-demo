package com.rhy.LazyInit.Lazy;

import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.LazyInit
 * @Version:1.0
 */
@Component
public class DogImpl implements Animal{
    @Override
    public void use() {
        System.out.println("狗：【"+DogImpl.class.getSimpleName()+"】看门用的");
    }
}
