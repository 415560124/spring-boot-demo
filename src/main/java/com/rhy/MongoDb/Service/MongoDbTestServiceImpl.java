package com.rhy.MongoDb.Service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.rhy.entity.admin.Admins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDbTestServiceImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 如果存在id相同的对象，那么就更新其属性
     * @param user
     */
    public void saveAdmins(Admins admins){
        mongoTemplate.save(admins,"admins");
    }

    /**
     * 移除管理员
     * 先构建查询条件
     * 执行查询条件，获得查询数据
     * 移除查询出来的数据
     * @param id 移除的User  id
     * @return
     */
    public DeleteResult deleteAdmins(int id){
        //构建查询准则
        Criteria criteria = Criteria.where("aId").is(id);
        //构建查询条件
        Query query = Query.query(criteria);
               //移除查询数据，映射User.class
        return mongoTemplate.remove(query,Admins.class);
    }

    /**
     * 查询管理员
     * @param aName
     * @param aSex
     * @param limit 查询...条
     * @param skip  跳过...条
     * @return
     */
    public List<Admins> findAdmins(String aName,int aSex,int limit,int skip){
        //构建查询准则  regex:模糊查询
        Criteria criteria =Criteria.where("aName").regex(aName).and("aSex").is(aSex);
        //构建查询条件
        Query query = Query.query(criteria).limit(limit).skip(skip);
        //执行
        return mongoTemplate.find(query,Admins.class);
    }

    /**
     * 修改管理员
     * @param id
     * @param aName
     * @param aLastTime
     * @return
     */
    public UpdateResult updateAdmins(int id,String aName,String aLastTime){
        //构建查询准则
        Criteria criteria = Criteria.where("aId").is(id);
        //构建查询条件
        Query query = Query.query(criteria);
        //设置修改对象
        Update update = Update.update("aName",aName);
        update.set("aLastTime",aLastTime);
        //修改多条
        //return mongoTemplate.updateMulti(query,update,Admins.class);
        //修改一条
        return mongoTemplate.updateFirst(query,update,Admins.class);
    }

    /**
     * 按id查询管理员
     * @param id
     * @return
     */
    public Admins getAdmins(int id){
        //如果只需要获取第一个
        //Criteria criteria = Criterial.where("aId").is(id);
        //Query query = Query.query(criteria);
        //return mongoTemplate.findOne(query,Admins.class);
        return mongoTemplate.findById(id,Admins.class);
    }
}
