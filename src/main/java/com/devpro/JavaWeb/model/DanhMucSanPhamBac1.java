package com.devpro.JavaWeb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "danh_muc_san_pham_bac1")
public class DanhMucSanPhamBac1 extends BaseEntity{

	
	@Column(name = "ten_dm", length = 100, nullable = false)
	private String tenDanhMuc;

	@Column(name = "status")
	private Integer status = 1;
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "danhMucSanPhamBac1")
	private Set<DanhMucSanPhamBac2> listDanhMucSanPhamBac2 = new HashSet<DanhMucSanPhamBac2>();
	
	
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public Set<DanhMucSanPhamBac2> getListDanhMucSanPhamBac2() {
		return listDanhMucSanPhamBac2;
	}

	public void setListDanhMucSanPhamBac2(Set<DanhMucSanPhamBac2> listDanhMucSanPhamBac2) {
		this.listDanhMucSanPhamBac2 = listDanhMucSanPhamBac2;
	}
	
	
}
