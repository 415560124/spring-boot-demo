package com.rhy.entity.emp;

/**
 * 实体类-职务
 * 
 * @author LSN
 *
 */
public class Job {
	/**
	 * 职位编号
	 */
	private int jids;
	/**
	 * 职位名称
	 */
	private String jname;

	public int getJids() {
		return jids;
	}

	public void setJids(int jids) {
		this.jids = jids;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public Job() {
		super();
	}

	/**
	 * 有参构造
	 * 
	 * @param jids  职位编号
	 * @param jname 职位名称
	 */
	public Job(int jids, String jname) {
		super();
		this.jids = jids;
		this.jname = jname;
	}

	@Override
	public String toString() {
		return "Job [jids=" + jids + ", jname=" + jname + "]";
	}

}
