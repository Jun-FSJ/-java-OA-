package com.jun.pageutil;

import java.io.Serializable;
import java.util.List;

public class EasyUIGrid implements Serializable{
	private List<?> rows;
	private long total;
	private long size;
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
}
