package com.devpro.JavaWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cua_hang")
public class CuaHang extends BaseEntity{
	
	@Column(name = "ten_cua_hang", length = 200, nullable = false)
	private String tenCuaHang;
	
	@Column(name = "thoi_gian_hoat_dong", length = 30, nullable = true)
	private String thoiGian;
	
	@Column(name = "dien_thoai", length = 15, nullable = true)
	private String dienThoai;
	
	@Column(name = "dia_chi_cu_the", length = 200, nullable = true)
	private String diaChi;
	
	@Column(name = "status")
	private Integer status = 1;

	public String getTenCuaHang() {
		return tenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
