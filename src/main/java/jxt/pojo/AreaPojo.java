
package jxt.pojo;

import java.io.Serializable;

/**
 * @author tangshun
 * 2015年7月26日
 * Ver 1.0
 */
public class AreaPojo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String areaId;
	private String areaName;
	private String parentId;
	private String address;
	private String remark;
	private String website;
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "AreaPojo [areaId=" + areaId + ", areaName=" + areaName
				+ ", parentId=" + parentId + ", address=" + address
				+ ", remark=" + remark + ", website=" + website + "]";
	}
	
	
	
}
