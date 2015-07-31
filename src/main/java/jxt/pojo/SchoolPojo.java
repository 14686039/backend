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

package jxt.pojo;

import java.io.Serializable;

/**
 * @author tangshun
 * 2015年7月31日
 * Ver 1.0
 */
public class SchoolPojo implements Serializable {

	        
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String school_id;
	private String area_id;
	private String school_name;
	private String school_code;
	private String parent_id;
	private String website;
	private String school_desc;
	private String address;
	private String remark;
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getSchool_code() {
		return school_code;
	}
	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getSchool_desc() {
		return school_desc;
	}
	public void setSchool_desc(String school_desc) {
		this.school_desc = school_desc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "SchoolPojo [school_id=" + school_id + ", area_id=" + area_id
				+ ", school_name=" + school_name + ", school_code="
				+ school_code + ", parent_id=" + parent_id + ", website="
				+ website + ", school_desc=" + school_desc + ", address="
				+ address + ", remark=" + remark + "]";
	}
	
	
	
}
