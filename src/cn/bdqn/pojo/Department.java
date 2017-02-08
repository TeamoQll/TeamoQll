package cn.bdqn.pojo;

import java.util.Date;

public class Department {
	private Integer id;
	private String depName;
	private Integer depNum;
	private Date creationDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Integer getDepNum() {
		return depNum;
	}
	public void setDepNum(Integer depNum) {
		this.depNum = depNum;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
}
