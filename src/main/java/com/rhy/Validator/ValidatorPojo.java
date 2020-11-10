package com.rhy.Validator;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/19
 * @Description: com.rhy.Validator
 * @Version:1.0
 */
public class ValidatorPojo {
    //非空判断
    @NotNull(message = "id不能为空")
    private int id;

    //只能是将来日期
    @Future(message = "需要一个将来日期")
    //日期格式转化
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //非空
    @NotNull
    private Date date;

    //不能为空
    @NotNull
    //最小值
    @DecimalMin(value = "0.1")
    //最大值
    @DecimalMax(value = "10000.00")
    private Integer integer;

    //限定范围
    @Range(min = 1,max = 888,message = "范围为1~888")
    private Long range;

    //邮箱验证
    @Email(message = "邮箱格式错误")
    private String emall;

    //字符串长度限制
    @Size(min = 20,max = 30,message = "字符串长度20到30之间")
    private String size;

    public ValidatorPojo() {
    }

    public ValidatorPojo(@NotNull(message = "id不能为空") int id, @Future(message = "需要一个将来日期") @NotNull Date date, @NotNull @DecimalMin(value = "0.1") @DecimalMax(value = "10000.00") Integer integer, @Range(min = 1, max = 888, message = "范围为1~888") Long range, @Email(message = "邮箱格式错误") String emall, @Size(min = 20, max = 30, message = "字符串长度20到30之间") String size) {
        this.id = id;
        this.date = date;
        this.integer = integer;
        this.range = range;
        this.emall = emall;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    public String getEmall() {
        return emall;
    }

    public void setEmall(String emall) {
        this.emall = emall;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ValidatorPojo{" +
                "id=" + id +
                ", date=" + date +
                ", integer=" + integer +
                ", range=" + range +
                ", emall='" + emall + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
