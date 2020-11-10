package com.rhy.Admins.Service;

import com.rhy.Admins.Dao.IAdminsDao;
import com.rhy.Admins.Dao.IAdminsDynSqlDao;
import com.rhy.entity.admin.Admins;
import com.rhy.entity.admin.AdminsWhere;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: com.rhy.Admins.Service
 * @Version:1.0
 */
@Service
public class AdminsServiceImpl {
    @Autowired
    IAdminsDao adminsDao;
    @Autowired
    IAdminsDynSqlDao adminsDynSqlDao;
    /**
     * 获得所有管理员信息
     * @return
     */
    public List<Admins> getAllAdmin(){

        return adminsDao.select();
    }

    /**
     * 按管理员id搜索
     * @param id 管理员id
     * @return 管理员信息
     */
    public Admins getAdminById(int id){
        return adminsDao.getAdminById(id);
    }

    /**
     * 按查询条件搜索
     * @param adminsWhere 管理员查询条件POJO
     * @return 管理员列表
     */
    public List<Admins> getAdminByWhere(AdminsWhere adminsWhere){
        return adminsDynSqlDao.getAdmins(adminsWhere);
    }
}
