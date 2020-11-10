package com.rhy.MongoDb.Controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.rhy.MongoDb.Service.MongoDbTestServiceImpl;
import com.rhy.entity.admin.Admins;
import com.rhy.entity.admin.Rule;
import com.sun.jmx.snmp.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mongoDb")
public class MongoDbController {
    @Autowired
    MongoDbTestServiceImpl testService;

    /**
     * 新增/更新管理员
     * @param admins
     * @return
     */
    @RequestMapping("/saveAdmins")
    public Admins saveAdmins(@RequestBody Admins admins){
        testService.saveAdmins(admins);
        return admins;
    }

    /**
     * 按id查询管理员
     * @param req
     * @return
     */
    @RequestMapping("/getAdmins")
    public Admins getAdmins(@RequestBody Map<String,Object> req){
        return testService.getAdmins((Integer) req.get("aId"));
    }

    /**
     * 按条件查询管理员
     * @param req
     * @return
     */
    @RequestMapping("/findAdmins")
    public List<Admins> findAdmins(@RequestBody Map<String,Object> req){
        return testService.findAdmins((String) req.get("aName"),(int)req.get("aSex"),(int)req.get("limit"),(int)req.get("skip"));
    }

    /**
     * 修改管理员信息
     * @param req
     * @return
     */
    @RequestMapping("/updateAdmins")
    public UpdateResult updateAdmins(@RequestBody Map<String,Object> req){
        return testService.updateAdmins((int)req.get("aId"),(String) req.get("aName"),(String) req.get("aLastTime"));
    }

    /**
     * 删除管理员信息
     * @param req
     * @return
     */
    @RequestMapping("/deleteAdmins")
    public DeleteResult deleteAdmins(@RequestBody Map<String,Object> req){
        return testService.deleteAdmins((int)req.get("aId"));
    }
    @Autowired
    MongoTemplate mongoTemplate;
    /**
     * 测试数据
     * @return
     */
    @RequestMapping("/testData")
    public List<Admins> testData(){
        List<Admins> res = new ArrayList<>();

        Rule rule1 = new Rule();
        rule1.setrId(1);
        rule1.setrName("角色1");
        Rule rule2= new Rule();
        rule2.setrId(2);
        rule2.setrName("角色2");
        mongoTemplate.save(rule1,"rule");
        mongoTemplate.save(rule2,"rule");
        Admins admins;
        Rule rule;
        for(int i=1;i<=100;i++){
            admins = new Admins();
            admins.setaId(i);
            admins.setaName("测试管理员"+i);
            admins.setaAcount("admins"+i);
            admins.setaLastTime(String.valueOf(new Timestamp().getDateTime()));
            admins.setaPassword("admins"+i);
            if(i%2 != 0){
                admins.setaSex(1);
                admins.setaStatus(1);
            }else{
                admins.setaSex(2);
                admins.setaStatus(2);
            }
            if(i<=50){
                rule = rule1;
            }else {
                rule = rule2;
            }
            admins.setRule(rule);
            mongoTemplate.save(admins,"admins");
            res.add(admins);
        }
        return res;
    }
}
