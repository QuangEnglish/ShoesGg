package com.devpro.JavaWeb.dto;

import com.ibm.icu.math.BigDecimal;

public class SanPhamSearch extends BaseSearchModel{

	private String keyword;
	
	private String danhMucId;
	
	private String status;
	
	private Integer statusSearch;

	private String tenSp;
	
	private BigDecimal minPrice;
	
	private BigDecimal maxPrice;
	
	private String phienBan;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDanhMucId() {
		return danhMucId;
	}

	public void setDanhMucId(String danhMucId) {
		this.danhMucId = danhMucId;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	public Integer getStatusSearch() {
		return statusSearch;
	}

	public void setStatusSearch(Integer statusSearch) {
		this.statusSearch = statusSearch;
	}

	public String getPhienBan() {
		return phienBan;
	}

	public void setPhienBan(String phienBan) {
		this.phienBan = phienBan;
	}

	
	
	
}
