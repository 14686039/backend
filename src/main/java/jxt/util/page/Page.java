package jxt.util.page;

import java.util.Collections;
import java.util.List;

public class Page<E> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int pageShow = 2;//每页显示几条的数量
	private int totalPage;
	private int totalCount;
	private int start;
	private int nowPage;
	private List<E> result = Collections.emptyList();
	
	public Page(int pageShow, int totalPage, int totalCount, int start,
			int nowPage, List<E> result) {
		super();
		this.pageShow = pageShow;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.start = start;
		this.nowPage = nowPage;
		this.result = result;
	}

	public Page(){
		
	}

	public int getStart() {
		start = (getNowPage() - 1) * getPageShow();
		if (start < 0) {
			start = 0;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageShow() {
		return pageShow;
	}

	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getResult() {
		return result;
	}

	public void setResult(List<E> result) {
		this.result = result;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return (int) Math.ceil(totalCount * 1.0 / pageShow);
	}

	public int getNowPage() {
		if (nowPage <= 0)
			nowPage = 1;
		if (nowPage > getTotalPage())
			nowPage = getTotalPage();
		return nowPage;
	}

	@Override
	public String toString() {
		return "Page [pageShow=" + pageShow + ", totalPage=" + getTotalPage()
				+ ", totalCount=" + totalCount + ",start="+start+", nowPage=" + nowPage
				+ ", result=" + result + "]";
	}

}