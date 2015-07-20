/*
 * Copyright (c) 2014 Nanjing Sesan Medical Technology Co.,Ltd.
 * All Rights Reserved
 * The software and information contained herein are proprietary to, and
 * comprise valuable trade secrets of, Nanjing Sesan Medical Technology Co.,Ltd., 
 * which intends to preserve as trade secrets such software and information.
 * This software is an unpublished copyright of Nanjing Sesan Medical Technology Co.,Ltd.. 
 * and may not be used, copied, transmitted, or stored in any manner. 
 * This software and information or any other copies thereof may
 * not be provided or otherwise made available to any other person.
 */

package jxt.util;

import java.util.List;

/**
 * @author tangshun
 * 2015年7月20日
 * Ver 1.0
 */
public class Pojo {
	private String name;
	private Integer id;
	private String addr;
	private String op;
	private List<String>  son;
	
	public String getName() {
		return name;
	}
	public List<String> getSon() {
		return son;
	}
	public void setSon(List<String> son) {
		this.son = son;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	@Override
	public String toString() {
		return "Pojo [name=" + name + ", id=" + id + ", addr=" + addr + ", op="
				+ op + "]";
	}

	
	

}
