package com.rhy.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/19
 * @Description: com.rhy.Validator
 * @Version:1.0
 */
@RestController
@RequestMapping("/validator")
public class ValidatorController {
    @RequestMapping("/validator")
    public Map<String,Object> validator(@Valid @RequestBody ValidatorPojo validatorPojo, Errors errors){
        Map<String,Object> res = new HashMap<>();
        System.out.println(validatorPojo);
        //获取错误列表
        List<ObjectError> observables = errors.getAllErrors();
        System.out.println(observables);
        if(observables != null && observables.size()!=0){
            res.put("code",2);
            res.put("msg","信息格式有误");
            for(ObjectError objectError : observables){
                String key = null;
                String msg = null;
                //字段错误
                if(objectError instanceof FieldError){
                    FieldError fieldError = (FieldError) objectError;
                    key = fieldError.getField();//获取错误验证字段名
                }else{
                    //非字段错误
                    key = objectError.getObjectName(); //获取验证对象名称
                }
                //错误信息
                msg = objectError.getDefaultMessage();
                res.put(key,msg);
            }
        }else{
            res.put("code",1);
            res.put("msg","信息格式正常");
        }

        return res;
    }
}
