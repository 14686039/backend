package jxt.pojo;

import jxt.util.page.Page;

/**
 * @author tangshun
 * 2015年7月29日
 * Ver 1.0
 */
public class BasePojo implements java.io.Serializable{

	private String search;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	private Page page;

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}	

}
