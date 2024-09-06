package com.devpro.JavaWeb.dto;

public abstract class BaseSearchModel {
	
	private Integer page;
	
	private int sizeOfPage;
	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getSizeOfPage() {
		return sizeOfPage;
	}

	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	
	
	
}
