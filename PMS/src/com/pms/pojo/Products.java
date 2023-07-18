package com.pms.pojo;

import java.sql.Date;

public class Products {
	
	private int pid;
	private String pname;
	private double price;
	private Date dom;
	
	public Products(){
		super();
	}

	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDom() {
		return dom;
	}
	
	public void setDom(Date dom) {
		this.dom = dom;
	}
	
	@Override
	public String toString() {
		return "pid = " + this.pid + "   pname = " + this.pname + "   price = " + this.price + "   dom = " + this.dom;
	}
	
}