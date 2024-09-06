package com.devpro.JavaWeb.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "khach_hang")
public class KhachHang extends BaseEntity{

	@Column(name = "ho_ten", length = 40, nullable = false)
	private String hoTen;
	
	
	@Column(name = "ngay_sinh", nullable = true)
	private Date ngaySinh;
	
	
	@Column(name = "so_dien_thoai", length = 15 ,nullable = true)
	private String soDienThoai;
	
	
	@Column(name = "email", length = 45, nullable = true)
	private String email;
	
	
	@Column(name = "ten_dang_nhap", length = 45, nullable = true)
	private String tenDangNhap;
	
	
	@Column(name = "mat_khau", length = 45, nullable = true)
	private String matKhau;
	
	@Column(name = "dia_chi", length = 500, nullable = true)
	private String diaChi;
	
	@Column(name = "gioi_tinh", length = 45, nullable = true)
	private String gioiTinh;
	
	@Column(name = "status", nullable = false)
	private Boolean status = Boolean.TRUE;
	
	@Column(name = "id_tai_khoan")
	private Integer idTaiKhoan;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "khachHang")
	private Set<HoaDon> hoaDons = new HashSet<HoaDon>();
	
	@OneToOne(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			mappedBy = "khachHangGH")
	private GioHangYeuThich gioHangYeuThich;
	
	
	
	public Set<HoaDon> getHoaDons() {
		return hoaDons;
	}


	public void setHoaDons(Set<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}


	public GioHangYeuThich getGioHangYeuThich() {
		return gioHangYeuThich;
	}


	public void setGioHangYeuThich(GioHangYeuThich gioHangYeuThich) {
		this.gioHangYeuThich = gioHangYeuThich;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTenDangNhap() {
		return tenDangNhap;
	}


	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}


	public String getMatKhau() {
		return matKhau;
	}


	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public Integer getIdTaiKhoan() {
		return idTaiKhoan;
	}


	public void setIdTaiKhoan(Integer idTaiKhoan) {
		this.idTaiKhoan = idTaiKhoan;
	}
	
	
	
}
