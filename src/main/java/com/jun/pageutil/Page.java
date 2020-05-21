package com.jun.pageutil;

public class Page {
	private Long totalPageSum;
	private Integer pageIndex;
	private Long totalRecordSum;
	
	public Long getTotalPageSum() {
		return totalPageSum;
	}
	public void setTotalPageSum(Long totalPageSum) {
		this.totalPageSum = totalPageSum;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Long getTotalRecordSum() {
		return totalRecordSum;
	}
	public void setTotalRecordSum(Long totalRecordSum) {
		this.totalRecordSum = totalRecordSum;
	}
	
}
