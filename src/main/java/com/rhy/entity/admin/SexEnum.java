package com.rhy.entity.admin;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: com.rhy.entity.admin
 * @Version:1.0
 */
public enum SexEnum {
    MAN(1,"男"),WOMAN(2,"女");
    /**
     * 编号
     */
    private final int id;
    /**
     *  性别名
     */
    private final String name;
    SexEnum(int id,String name){
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEnumById(int id){
        for(SexEnum sexEnum : SexEnum.values()){
            if(sexEnum.id == id){
                return sexEnum;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
