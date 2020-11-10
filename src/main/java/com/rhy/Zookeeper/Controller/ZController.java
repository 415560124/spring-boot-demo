package com.rhy.Zookeeper.Controller;

import com.rhy.Zookeeper.Service.IZService;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RequestMapping("/Zookeeper")
@RestController
public class ZController {
    @Autowired
    ZooKeeper zooKeeper;
    //返回结果集
    Map<String,Object> res = new HashMap<>();
    @Autowired
    IZService service;
    //日志
    private static final Logger logger = Logger.getLogger(ZController.class.toString());
    /**
     * 查看Zookeeper状态信息
     * @return
     */
    @RequestMapping("/showZookeeper")
    public Map<String,Object> showZookeeper(){
        res.put("code","1");
        res.put("msg","ok");
        res.put("zookeeper",zooKeeper.getState());
        return res;
    }
    @RequestMapping("/getChildren")
    public Map<String,Object> getChildren(@RequestBody Map<String,Object> req) throws KeeperException, InterruptedException {
        res.put("code","1");
        res.put("msg","ok");
        //同步返回结果
        res.put("data",service.getChildren((String) req.get("path"),null));
        //异步返回结果
        service.getChildren((String) req.get("path"), null, new AsyncCallback.ChildrenCallback() {
            /**
             * 异步返回结果的回调方法
             * @param resultCode 状态码
             *                   0：调用成功
             *                   -4：客户端与服务端已断开连接
             *                   -110：指定节点已存在
             *                   -112：会话
             * @param path 路径
             * @param context 传入回调方法的上下文对象
             * @param list 返回数据
             */
            @Override
            public void processResult(int resultCode, String path, Object context, List<String> list) {
                logger.info("==========================getChildren()-异步返回结果的回调方法=================================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                logger.info("List<String> list="+list);
                logger.info("==========================getChildren()-异步返回结果的回调方法结束=================================");
            }
        },this);

        service.getChildren((String) req.get("path"),null,new AsyncCallback.Children2Callback(){
            /**
             * 异步返回结果的回调方法
             * @param resultCode 状态码
             *                   0：调用成功
             *                   -4：客户端与服务端已断开连接
             *                   -110：指定节点已存在
             *                   -112：会话
             * @param path 路径
             * @param context 传入回调方法的上下文对象
             * @param list 返回数据
             * @param stat 节点Stat信息
             */
            @Override
            public void processResult(int resultCode, String path, Object context, List<String> list, Stat stat) {
                logger.info("==============================getChildren()-异步返回结果的回调方法（带Stat）=====================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                logger.info("List<String> list="+list);
                logger.info("Stat stat="+stat.toString());
                logger.info("==============================getChildren()-异步返回结果的回调方法（带Stat）结束=====================");
            }
        },this);
        return res;
    }
    @RequestMapping("/exists")
    public Map<String,Object> exists(@RequestBody Map<String,Object> req) throws KeeperException, InterruptedException {
        res.put("code","1");
        res.put("msg","ok");
        //同步返回结果
        Stat stat = service.exists((String) req.get("path"),null);
        res.put("data",stat);
        //异步返回结果
        service.exists((String) req.get("path"), null, new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int resultCode, String path, Object context, Stat stat) {
                logger.info("==============================exists()-异步返回结果的回调方法=====================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                logger.info("Stat stat="+(stat == null ? null : stat.toString()));
                logger.info("==============================exists()-异步返回结果的回调方法=====================");
            }
        },this);
        return res;
    }
    @RequestMapping("/create")
    public Map<String,Object> create(@RequestBody Map<String,Object> req) throws KeeperException, InterruptedException {
        res.put("code","1");
        res.put("msg","ok");
        //同步创建节点
        res.put("data",service.create((String)req.get("path"),((String)req.get("data")).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
        //异步创建节点
        service.create((String) req.get("path")+"-asyn", ((String) req.get("data")).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
            @Override
            public void processResult(int resultCode, String path, Object context, String data) {
                logger.info("==============================create()-异步返回结果的回调方法=====================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                logger.info("String data="+data);
                logger.info("==============================create()-异步返回结果的回调方法=====================");
            }
        },this);
        return res;
    }
    @RequestMapping("/getData")
    public Map<String,Object> getData(@RequestBody Map<String,Object> req) throws KeeperException, InterruptedException,UnsupportedEncodingException{
        res.put("code","1");
        res.put("msg","ok");
        //同步

        res.put("data",new String(service.getData((String)req.get("path"),null,null),"GBK"));
        //异步
        service.getData((String) req.get("path"), null, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int resultCode, String path, Object context, byte[] bytes, Stat stat) {
                logger.info("==============================getData()-异步返回结果的回调方法=====================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                try {
                    logger.info("byte[] bytes="+new String(bytes,"GBK"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                logger.info("Stat stat="+stat);
                logger.info("==============================getData()-异步返回结果的回调方法=====================");
            }
        },this);
        return res;
    }
    @RequestMapping("/setData")
    public Map<String,Object> setData(@RequestBody Map<String,Object> req) throws KeeperException, InterruptedException,UnsupportedEncodingException{
        res.put("code","1");
        res.put("msg","ok");
        //同步
        res.put("data",service.setData((String)req.get("path"),((String)req.get("data")).getBytes(),(int)req.get("version")));
        //异步
        service.setData((String) req.get("path"), ((String)req.get("data")).getBytes(),(int)req.get("version"), new AsyncCallback.StatCallback(){

            @Override
            public void processResult(int resultCode, String path, Object context, Stat stat) {
                logger.info("==============================setData()-异步返回结果的回调方法=====================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                logger.info("Stat stat="+stat);
                logger.info("==============================setData()-异步返回结果的回调方法=====================");
            }
        },this);
        return res;
    }

    @RequestMapping("/delete")
    public Map<String,Object> delete(@RequestBody Map<String,Object> req) throws KeeperException, InterruptedException,UnsupportedEncodingException{
        res.put("code","1");
        res.put("msg","ok");
        //同步
        service.delete((String)req.get("path"),(int)req.get("version"));
        //异步
        service.delete((String) req.get("path")+"-asyn",(int)req.get("version"), new AsyncCallback.VoidCallback(){

            @Override
            public void processResult(int resultCode, String path, Object context) {
                logger.info("==============================delete()-异步返回结果的回调方法=====================");
                logger.info("int resultCode="+resultCode);
                logger.info("String path="+path);
                logger.info("Object context="+context);
                logger.info("==============================delete()-异步返回结果的回调方法=====================");
            }
        },this);
        return res;
    }
}
