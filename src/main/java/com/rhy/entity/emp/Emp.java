package com.rhy.entity.emp;

import java.math.BigDecimal;

/**
 * 实体类-员工
 * 
 * @author LSN
 *
 */
public class Emp {
	/**
	 * 员工编号
	 */
	private int eids;
	/**
	 * 员工名称
	 */
	private String ename;
	/**
	 * 员工性别
	 */
	private int esex;
	/**
	 * 员工生日
	 */
	private Long ebirthday;
	/**
	 * 员工联系方式
	 */
	private String etel;
	/**
	 * 员工住址
	 */
	private String eaddr;
	/**
	 * 入职时间
	 */
	private Long ehiredate;
	/**
	 * 部门编号
	 */
	private Dept dept;
	private int edids;
	/**
	 * 职位编号
	 */
	private Job job;
	private int ejids;
	/**
	 * 上级编号
	 */
	private int emgr;
	/**
	 * 工资
	 */
	private BigDecimal esal;
	/**
	 * 奖金
	 */
	private BigDecimal ecomm;
	/**
	 * 奖金
	 */
	public Emp() {
	}

	public Emp(int eids, String ename, int esex, Long ebirthday, String etel, String eaddr, Long ehiredate, Dept dept, int edids, Job job, int ejids, int emgr, BigDecimal esal, BigDecimal ecomm) {
		this.eids = eids;
		this.ename = ename;
		this.esex = esex;
		this.ebirthday = ebirthday;
		this.etel = etel;
		this.eaddr = eaddr;
		this.ehiredate = ehiredate;
		this.dept = dept;
		this.edids = edids;
		this.job = job;
		this.ejids = ejids;
		this.emgr = emgr;
		this.esal = esal;
		this.ecomm = ecomm;
	}

	@Override
	public String toString() {
		return "Emp{" +
				"eids=" + eids +
				", ename='" + ename + '\'' +
				", esex=" + esex +
				", ebirthday=" + ebirthday +
				", etel='" + etel + '\'' +
				", eaddr='" + eaddr + '\'' +
				", ehiredate=" + ehiredate +
				", dept=" + dept +
				", edids=" + edids +
				", job=" + job +
				", ejids=" + ejids +
				", emgr=" + emgr +
				", esal=" + esal +
				'}';
	}

	public int getEids() {
		return eids;
	}

	public void setEids(int eids) {
		this.eids = eids;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEsex() {
		return esex;
	}

	public void setEsex(int esex) {
		this.esex = esex;
	}

	public Long getEbirthday() {
		return ebirthday;
	}

	public void setEbirthday(Long ebirthday) {
		this.ebirthday = ebirthday;
	}

	public String getEtel() {
		return etel;
	}

	public void setEtel(String etel) {
		this.etel = etel;
	}

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

	public Long getEhiredate() {
		return ehiredate;
	}

	public void setEhiredate(Long ehiredate) {
		this.ehiredate = ehiredate;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getEdids() {
		return edids;
	}

	public void setEdids(int edids) {
		this.edids = edids;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getEjids() {
		return ejids;
	}

	public void setEjids(int ejids) {
		this.ejids = ejids;
	}

	public int getEmgr() {
		return emgr;
	}

	public void setEmgr(int emgr) {
		this.emgr = emgr;
	}

	public BigDecimal getEsal() {
		return esal;
	}

	public void setEsal(BigDecimal esal) {
		this.esal = esal;
	}

	public BigDecimal getEcomm() {
		return ecomm;
	}

	public void setEcomm(BigDecimal ecomm) {
		this.ecomm = ecomm;
	}
}
