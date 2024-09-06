package com.devpro.JavaWeb.model;

import java.math.BigDecimal;
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

import com.ibm.icu.text.DecimalFormat;

@Entity
@Table(name = "san_pham")
public class SanPham extends BaseEntity{

	@Column(name = "ten_sp", length = 100, nullable = false)
	private String tenSanPham;
	
	@Column(name = "so_luong", nullable = true)
	private Integer soLuong;
	
	@Column(name = "size", length = 20, nullable = true)
	private String size;
	
	@Column(name = "gia", precision = 13, scale = 0, nullable = true)
	private BigDecimal gia;
	
	
	@Column(name = "form_dang", length = 200 ,nullable = true)
	private String formDang;
	
	@Column(name = "thiet_ke", columnDefinition = "LONGTEXT", nullable = true)
	private String thietKe;
	
	@Column(name = "chat_lieu", columnDefinition = "LONGTEXT", nullable = true)
	private String chatLieu;
	
	@Column(name = "hinh_anh", length = 50, nullable = true)
	private String hinhAnh;
	
	
	@Column(name = "mau_sac", length = 100, nullable = true)
	private String mauSac;
	
	@Column(name = "status", nullable = true)
	private Integer status = 1;
	

	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "sanPhamGH")
	private Set<GioHangYeuThich> gioHangYeuThichs = new HashSet<GioHangYeuThich>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dm_sp")
	private DanhMucSanPhamBac2 danhMucSanPhamBac2;
	

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dm_pk")
	private DanhMucPhuKien danhMucPhuKien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_bo_suu_tap")
	private BoSuuTap boSuuTap;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "sanPham")
	private Set<ChiTietHoaDon> chiTietHoaDons = new HashSet<ChiTietHoaDon>();
	
	
	
	
	public Set<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(Set<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public BoSuuTap getBoSuuTap() {
		return boSuuTap;
	}

	public void setBoSuuTap(BoSuuTap boSuuTap) {
		this.boSuuTap = boSuuTap;
	}

	public DanhMucPhuKien getDanhMucPhuKien() {
		return danhMucPhuKien;
	}

	public void setDanhMucPhuKien(DanhMucPhuKien danhMucPhuKien) {
		this.danhMucPhuKien = danhMucPhuKien;
	}

	public DanhMucSanPhamBac2 getDanhMucSanPhamBac2() {
		return danhMucSanPhamBac2;
	}

	public void setDanhMucSanPhamBac2(DanhMucSanPhamBac2 danhMucSanPhamBac2) {
		this.danhMucSanPhamBac2 = danhMucSanPhamBac2;
	}

	public Set<GioHangYeuThich> getGioHangYeuThichs() {
		return gioHangYeuThichs;
	}

	public void setGioHangYeuThichs(Set<GioHangYeuThich> gioHangYeuThichs) {
		this.gioHangYeuThichs = gioHangYeuThichs;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getGia() {
		
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public String getFormDang() {
		return formDang;
	}

	public void setFormDang(String formDang) {
		this.formDang = formDang;
	}

	public String getThietKe() {
		return thietKe;
	}

	public void setThietKe(String thietKe) {
		this.thietKe = thietKe;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		if(this.status == null) {
			this.status = 1;
		} else {
			this.status = status;
		}
	}

	public String getEpGia() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(gia);
	}
	
	
	
	
	
}
