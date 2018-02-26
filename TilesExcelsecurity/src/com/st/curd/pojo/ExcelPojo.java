package com.st.curd.pojo;

public class ExcelPojo {
	private Integer id;
	private String name;
	private String qual;
	private String addr;
	@Override
	public String toString() {
		return "ExcelPojo [id=" + id + ", name=" + name + ", qual=" + qual + ", addr=" + addr + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}


	
	

}
