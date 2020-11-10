package com.rhy.AOP.Controller;

import com.rhy.AOP.DeclareParents.Service.Animal;
import com.rhy.AOP.DeclareParents.Service.FemaleAnimal;
import com.rhy.AOP.DeclareParents.Service.Person;
import com.rhy.AOP.Service.Enhance.IDeptValidator;
import com.rhy.AOP.Service.IDeptService;
import com.rhy.entity.emp.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.Controller
 * @Version:1.0
 */
@RestController
@RequestMapping("/aspect")
public class AspectController {
    @Autowired
    IDeptService deptServiceImpl;
    @Autowired
    Person person;

    @RequestMapping("/printdept")
    public void printDept(@RequestBody Dept dept){

        deptServiceImpl.pringDept(dept);
    }
    @RequestMapping("/printdept2")
    public void printDept2(@RequestBody Dept dept){
        deptServiceImpl.pring2Dept(dept);
    }

    @RequestMapping("/decleare")
    public void decleare(){
        Animal animal = (Animal) person;
        animal.eat();
        person.likePerson();
    }

    @RequestMapping("/validator")
    public Dept validator(@RequestBody Dept dept){
        IDeptValidator iDeptValidator = (IDeptValidator) deptServiceImpl;
        if(iDeptValidator.validate(dept)){
            deptServiceImpl.pringDept(dept);
        }
        System.out.println(dept);
        return dept;
    }
    @RequestMapping("/manyAspect")
    public void manyAspect(@RequestBody Dept dept){

        deptServiceImpl.manyAspect(dept);
    }
}
