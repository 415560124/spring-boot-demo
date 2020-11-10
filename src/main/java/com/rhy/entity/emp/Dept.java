package com.rhy.entity.emp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 实体类-部门
 * 
 * @author LSN
 *
 */

/**
 * 默认为singleton 单例模式
 * SCOPE_PROTOTYPE：每次获取bean都新建一个Bean实例返回给调用者
 * SCOPE_SINGLETON：单例模式
 */
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

/**
 * SCOPE_SESSION：HTTP会话
 * SCOPE_APPLICATION:Web工程生命周期
 * SCOPE_REQUEST:Web工程单次请求
 *
 */
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Dept {
	/**
	 * 部门编号
	 */
	private int dids;
	/**
	 * 部门名称
	 */
	private String dname;

	public int getDids() {
		return dids;
	}

	public void setDids(int dids) {
		this.dids = dids;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Dept() {
		super();
	}

	/**
	 * 有参构造
	 * 
	 * @param dids  部门编号
	 * @param dname 部门名称
	 */
	public Dept(int dids, String dname) {
		super();
		this.dids = dids;
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dept [dids=" + dids + ", dname=" + dname + "]";
	}


}
