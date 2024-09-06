package com.devpro.JavaWeb.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.icu.text.DecimalFormat;

@Entity
@Table(name = "chi_tiet_hoa_don")
public class ChiTietHoaDon extends BaseEntity{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//	
	@Column(name = "so_luong")
	private Integer soLuong;
	
	@Column(name = "size")
	private String size;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sp")
	private SanPham sanPham;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_hd")
	private HoaDon hoaDon;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	public String epThanhTien() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(sanPham.getGia().multiply(BigDecimal.valueOf(this.soLuong)));
	}
	
	
}
