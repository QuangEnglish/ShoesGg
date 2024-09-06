package com.devpro.JavaWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gio_hang_yeu_thich")
public class GioHangYeuThich{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_khach_hang")
	private KhachHang khachHangGH;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_san_pham")
	private SanPham sanPhamGH;
	
	
	@Column(name = "soluong", nullable = true)
	private Integer soLuong;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public KhachHang getKhachHangGH() {
		return khachHangGH;
	}


	public void setKhachHangGH(KhachHang khachHangGH) {
		this.khachHangGH = khachHangGH;
	}


	public SanPham getSanPhamGH() {
		return sanPhamGH;
	}


	public void setSanPhamGH(SanPham sanPhamGH) {
		this.sanPhamGH = sanPhamGH;
	}


	public Integer getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
	
	
	
}
