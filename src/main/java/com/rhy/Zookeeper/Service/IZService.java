package com.rhy.Zookeeper.Service;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IZService {
    /**
     * 以同步方式列出子节点（如果不存在此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @return 子节点列表
     */
    List<String> getChildren(String path, Watcher watcher) throws KeeperException, InterruptedException;

    /**
     * 以异步方式列出子节点（如果不存在此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @param callback 回调方法
     * @param context 上下文对象
     */
    void getChildren(String path, Watcher watcher, AsyncCallback.ChildrenCallback callback,Object context);

    /**
     * 以异步方式列出子节点（如果不存在此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @param callback 回调方法(带stat)
     * @param context 上下文对象
     */
    void getChildren(String path, Watcher watcher, AsyncCallback.Children2Callback callback,Object context);

    /**
     * 以同步方式判断节点是否已存在
     * @param path 路径
     * @param watcher 监听器
     * @return 节点数据
     * stat不为null即可认为存在
     */
    Stat exists(String path,Watcher watcher) throws KeeperException, InterruptedException;

    /**
     * 以异步方式判断节点是否已存在
     * @param path 路径
     * @param watcher 监听器
     * @param callback 回调方法
     * @param context 上下文对象
     * 回调函数中：stat不为null即可认为存在
     */
    void exists(String path, Watcher watcher, AsyncCallback.StatCallback callback,Object context);

    /**
     * 同步方式创建节点（如果已经存在此节点会报异常）
     * @param path 节点路径
     * @param data 节点数据
     * @param acls 节点acl权限
     * @param createMode 节点创建模式
     * @return 节点路径
     */
    String create(String path, byte[] data, List<ACL> acls, CreateMode createMode) throws KeeperException, InterruptedException;

    /**
     * 以异步方式创建节点（如果已经存在此节点会报异常）
     * @param path 节点路径
     * @param data 节点数据
     * @param acls 节点acl权限
     * @param createMode 节点创建模式
     * @param callback 回调方法
     * @param context 上下文对象
     */
    void create(String path, byte[] data, List<ACL> acls, CreateMode createMode, AsyncCallback.StringCallback callback,Object context);

    /**
     * 获得节点数据 （如果没有此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @param stat 监视器
     * @return 节点数据
     */
    byte[] getData(String path,Watcher watcher,Stat stat) throws KeeperException, InterruptedException;

    /**
     * 以异步方式获得节点数据（如果没有此节点会报异常）
     * @param path 节点路径
     * @param watcher 监视器
     * @param callback 回调方法
     * @param context 上下文对象
     */
    void getData(String path, Watcher watcher, AsyncCallback.DataCallback callback,Object context);

    /**
     * 修改节点数据
     * @param path 节点路径
     * @param data 节点数据
     * @param version 节点版本 （最新版本参数： -1）
     * @return 节点统计数据
     * stat不为null即可认为修改成功
     */
    Stat setData(String path,byte[] data,int version) throws KeeperException, InterruptedException;

    /**
     * 异步修改节点数据
     * @param path 节点路径
     * @param data 节点数据
     * @param version 节点版本（最新版本参数： -1）
     * @param callback 回调函数
     * @param context 上下文信息
     * @return
     * 回调函数中：stat不为null即可认为修改成功
     */
    void setData(String path, byte[] data, int version, AsyncCallback.StatCallback callback,Object context);

    /**
     * 以同步方式删除节点 (没有节点会报异常)
     * @param path 节点路径
     * @param version 节点版本
     */
    void delete(String path,int version) throws KeeperException, InterruptedException;

    /**
     * 以异步方式删除节点 (没有节点会报异常)
     * @param path 节点路径
     * @param version 节点版本
     * @param callback 回调函数
     * @param context 上下文信息
     */
    void delete(String path, int version, AsyncCallback.VoidCallback callback,Object context);
}
