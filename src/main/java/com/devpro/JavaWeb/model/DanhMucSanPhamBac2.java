package com.devpro.JavaWeb.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "danh_muc_san_pham_bac2")
public class DanhMucSanPhamBac2 extends BaseEntity{



	@Column(name = "ten_dm", length = 100, nullable = false)
	private String tenDanhMuc;
	
	@Column(name = "status")
	private Integer status = 1;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dm_b1")
	private DanhMucSanPhamBac1 danhMucSanPhamBac1;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "danhMucSanPhamBac2")
	private Set<SanPham> sanPhams = new HashSet<SanPham>();
	
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public DanhMucSanPhamBac1 getDanhMucSanPhamBac1() {
		return danhMucSanPhamBac1;
	}

	public void setDanhMucSanPhamBac1(DanhMucSanPhamBac1 danhMucSanPhamBac1) {
		this.danhMucSanPhamBac1 = danhMucSanPhamBac1;
	}

	
		
}
