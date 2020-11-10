package com.rhy.Admins.Controller;

import com.rhy.Admins.Service.AdminsServiceImpl;
import com.rhy.entity.admin.Admins;
import com.rhy.entity.admin.AdminsWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: com.rhy.Admins.Controller
 * @Version:1.0
 */
@RestController
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    AdminsServiceImpl service;
    public static Logger logger = Logger.getLogger(AdminsController.class.getName());
    @RequestMapping("/getAllAdmin")
    public List<Admins> getAdmin(){
        return service.getAllAdmin();
    }
    @RequestMapping("/getAdminById")
    public Admins getAdminById(@RequestBody Map<String,Object> map){
        return service.getAdminById((Integer) map.get("id"));
    }
    @RequestMapping("/getAdminsByAdminsWhere")
    public List<Admins> getAdminsByAdminsWhere(@RequestBody AdminsWhere adminsWhere){
        logger.info(adminsWhere.toString());
        return service.getAdminByWhere(adminsWhere);
    }
}
