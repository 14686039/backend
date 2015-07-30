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
import java.sql.Timestamp;

/**
 * @author tangshun
 * 2015年7月29日
 * Ver 1.0
 */
public class AllianceBusinessPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String alliance_business_id;
	private String alliance_business_code;
	private String alliance_business_name;
	private String remark;
	
	private String areaId;
	private String areaName;
	private String schoolId;
	private String schoolName;
	private Timestamp startDt;
	private Timestamp endDt;
	
	
	
	@Override
	public String toString() {
		return "AllianceBusinessPojo [alliance_business_id="
				+ alliance_business_id + ", alliance_business_code="
				+ alliance_business_code + ", alliance_business_name="
				+ alliance_business_name + ", remark=" + remark + ", areaId="
				+ areaId + ", areaName=" + areaName + ", schoolId=" + schoolId
				+ ", schoolName=" + schoolName + ", startDt=" + startDt
				+ ", endDt=" + endDt + "]";
	}
	public String getAlliance_business_id() {
		return alliance_business_id;
	}
	public void setAlliance_business_id(String alliance_business_id) {
		this.alliance_business_id = alliance_business_id;
	}
	public String getAlliance_business_code() {
		return alliance_business_code;
	}
	public void setAlliance_business_code(String alliance_business_code) {
		this.alliance_business_code = alliance_business_code;
	}
	public String getAlliance_business_name() {
		return alliance_business_name;
	}
	public void setAlliance_business_name(String alliance_business_name) {
		this.alliance_business_name = alliance_business_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Timestamp getStartDt() {
		return startDt;
	}
	public void setStartDt(Timestamp startDt) {
		this.startDt = startDt;
	}
	public Timestamp getEndDt() {
		return endDt;
	}
	public void setEndDt(Timestamp endDt) {
		this.endDt = endDt;
	}
	
	
}
