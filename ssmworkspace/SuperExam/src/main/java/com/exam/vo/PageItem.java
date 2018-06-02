package com.exam.vo;

import java.util.List;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 16, 2016 
 * Time: 2:42:43 PM
 *
 * com.exam.vo.PageItem
 */
public class PageItem {
	private int currentPage;
	private int counts;
	private int pageSize;
	private List<?> items;
	private int startIndex;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getPageSize() {
		if(0 == pageSize){
			pageSize = 10;
		}
		
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	public int getStartIndex() {
		if (currentPage < 1) {
			currentPage = 1;
		}
		startIndex = pageSize * (currentPage - 1);
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
