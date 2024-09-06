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
@Table(name = "bo_suu_tap")
public class BoSuuTap extends BaseEntity{

	@Column(name = "ten_bo_suu_tap", length = 100, nullable = false)
	private String tenBST;
	
	
	@Column(name = "noi_dung", length = 200, nullable = true)
	private String noiDung; 
	
	
	@Column(name = "anh_tieu_de", length = 45, nullable = true)
	private String anhTieuDe;
	
	@Column(name = "anh_noi_dung", length = 45, nullable = true)
	private String anhNoiDung;
	
	
	@Column(name = "anh_danh_muc", length = 45, nullable = true)
	private String anhDanhMuc;
	
	
	@Column(name = "anh_phan_cuoi", length = 45, nullable = true)
	private String anhPhanCuoi;

	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "boSuuTap")
	private Set<SanPham> sanPhams = new HashSet<SanPham>();
	
	
	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}


	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}


	public String getTenBST() {
		return tenBST;
	}


	public void setTenBST(String tenBST) {
		this.tenBST = tenBST;
	}


	public String getNoiDung() {
		return noiDung;
	}


	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}


	public String getAnhTieuDe() {
		return anhTieuDe;
	}


	public void setAnhTieuDe(String anhTieuDe) {
		this.anhTieuDe = anhTieuDe;
	}


	public String getAnhNoiDung() {
		return anhNoiDung;
	}


	public void setAnhNoiDung(String anhNoiDung) {
		this.anhNoiDung = anhNoiDung;
	}


	public String getAnhDanhMuc() {
		return anhDanhMuc;
	}


	public void setAnhDanhMuc(String anhDanhMuc) {
		this.anhDanhMuc = anhDanhMuc;
	}


	public String getAnhPhanCuoi() {
		return anhPhanCuoi;
	}


	public void setAnhPhanCuoi(String anhPhanCuoi) {
		this.anhPhanCuoi = anhPhanCuoi;
	}
	
	
}
