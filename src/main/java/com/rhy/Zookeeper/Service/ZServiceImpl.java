package com.rhy.Zookeeper.Service;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZServiceImpl implements IZService{
    @Autowired
    ZooKeeper zooKeeper;

    /**
     * 以同步方式列出子节点
     * @param path 节点路径
     * @param watcher 监视器
     * @return 子节点列表
     */
    @Override
    public List<String> getChildren(String path, Watcher watcher) throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren(path,watcher);
        return children;
    }
    /**
     * 以异步方式列出子节点
     * @param path 节点路径
     * @param watcher 监视器
     * @param callback 回调方法
     * @param context 上下文对象
     */
    @Override
    public void getChildren(String path, Watcher watcher, AsyncCallback.ChildrenCallback callback, Object context) {
        zooKeeper.getChildren(path,watcher,callback,context);
    }
    /**
     * 以异步方式列出子节点
     * @param path 节点路径
     * @param watcher 监视器
     * @param callback 回调方法(带stat)
     * @param context 上下文对象
     */
    @Override
    public void getChildren(String path, Watcher watcher, AsyncCallback.Children2Callback callback, Object context) {
        zooKeeper.getChildren(path,watcher,callback,context);
    }
    /**
     * 以同步方式判断节点是否已存在
     * @param path 路径
     * @param watcher 监听器
     * @return 节点数据
     * stat不为null即可认为存在
     */
    @Override
    public Stat exists(String path, Watcher watcher) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path,watcher);
    }
    /**
     * 以异步方式判断节点是否已存在
     * @param path 路径
     * @param watcher 监听器
     * @param callback 回调方法
     * @param context 上下文对象
     * 回调函数中：stat不为null即可认为存在
     */
    @Override
    public void exists(String path, Watcher watcher, AsyncCallback.StatCallback callback, Object context) {
        zooKeeper.exists(path,watcher,callback,context);
    }

    /**
     * 同步方式创建节点（如果已经存在此节点会报异常）
     * @param path 节点路径
     * @param data 节点数据
     * @param acls 节点acl权限
     * @param createMode 节点创建模式
     * @return 节点路径
     */
    @Override
    public String create(String path, byte[] data, List<ACL> acls, CreateMode createMode) throws KeeperException, InterruptedException {

        return zooKeeper.create(path, data, acls, createMode);
    }
    /**
     * 以异步方式创建节点（如果已经存在此节点会报异常）
     * @param path 节点路径
     * @param data 节点数据
     * @param acls 节点acl权限
     * @param createMode 节点创建模式
     * @param callback 回调方法
     * @param context 上下文对象
     *
     */
    @Override
    public void create(String path, byte[] data, List<ACL> acls, CreateMode createMode, AsyncCallback.StringCallback callback, Object context) {
        zooKeeper.create(path, data, acls, createMode, callback, context);
    }
    /**
     * 获得节点数据 （如果没有此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @param stat 监视器
     * @return 节点数据
     */
    @Override
    public byte[] getData(String path, Watcher watcher, Stat stat) throws KeeperException, InterruptedException {
        return zooKeeper.getData(path,watcher,stat);
    }
    /**
     * 以异步方式获得节点数据（如果没有此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @param callback 回调方法
     * @param context 上下文对象
     *
     */
    @Override
    public void getData(String path, Watcher watcher, AsyncCallback.DataCallback callback, Object context) {
        zooKeeper.getData(path,watcher,callback,context);
    }
    /**
     * 修改节点数据
     * @param path 节点路径
     * @param data 节点数据
     * @param version 节点版本
     * @return 节点统计数据
     * stat不为null即可认为存在
     */
    @Override
    public Stat setData(String path, byte[] data, int version) throws KeeperException, InterruptedException {

        return zooKeeper.setData(path,data,version);
    }
    /**
     * 异步修改节点数据
     * @param path 节点路径
     * @param data 节点数据
     * @param version 节点版本
     * @param callback 回调函数
     * @param context 上下文信息
     * @return
     * 回调函数中：stat不为null即可认为修改成功
     */
    @Override
    public void setData(String path, byte[] data, int version, AsyncCallback.StatCallback callback, Object context) {
        zooKeeper.setData(path, data, version, callback, context);
    }
    /**
     * 以同步方式删除节点
     * @param path 节点路径
     * @param version 节点版本
     */
    @Override
    public void delete(String path, int version) throws KeeperException, InterruptedException {
        zooKeeper.delete(path,version);
    }
    /**
     * 以异步方式删除节点
     * @param path 节点路径
     * @param version 节点版本
     * @param callback 回调函数
     * @param context 上下文信息
     */
    @Override
    public void delete(String path, int version, AsyncCallback.VoidCallback callback, Object context) {
        zooKeeper.delete(path, version, callback, context);
    }

}
