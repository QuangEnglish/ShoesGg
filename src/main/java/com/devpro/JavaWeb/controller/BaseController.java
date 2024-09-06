package com.devpro.JavaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.devpro.JavaWeb.model.BoSuuTap;
import com.devpro.JavaWeb.model.DanhMucPhuKien;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac1;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac2;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.model.TaiKhoan;
import com.devpro.JavaWeb.services.impl.BoSuuTapService;
import com.devpro.JavaWeb.services.impl.DanhMucBac1Service;
import com.devpro.JavaWeb.services.impl.DanhMucBac2Service;
import com.devpro.JavaWeb.services.impl.DanhMucPhuKienService;
import com.devpro.JavaWeb.services.impl.KhachHangService;

public abstract class BaseController {
	
	@Autowired
	private DanhMucBac2Service danhMucBac2Service;
	
	@Autowired
	private DanhMucPhuKienService danhMucPhuKienService;
	
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	DanhMucBac1Service danhMucBac1Service;
	
	@Autowired
	BoSuuTapService boSuuTapService;
	
	@ModelAttribute("danhMucSanPhamBac2")
	public List<DanhMucSanPhamBac2> getAllDanhMucBac2(){
		return danhMucBac2Service.findAll();
	}
	

	@ModelAttribute("danhMucPhuKien")
	public List<DanhMucPhuKien> getAllDanhMucPhuKien(){
		return danhMucPhuKienService.findAll();
	}
	
	@ModelAttribute("danhMucSanPhamBac1")
	public List<DanhMucSanPhamBac1> getAllDanhMucBac1(){
		return danhMucBac1Service.findAll();
	}
	
	
	@ModelAttribute("danhMucBoSuuTap")
	public List<BoSuuTap> getAllBoSuuTap(){
		return boSuuTapService.findAll();
	}
	
	@ModelAttribute("userLogined")
	public TaiKhoan getUserLogined(){
		Object userLogin = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogin != null && userLogin instanceof UserDetails) {
			return (TaiKhoan) userLogin;
		}
		return new TaiKhoan();
	}
	
	@ModelAttribute("isLogined")
	public boolean isLogined() {
		boolean isLogined = false;
		Object userLogin = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogin != null && userLogin instanceof UserDetails) {
			isLogined = true;
		}
		return isLogined;
	}
	
	
	@ModelAttribute("khachHang")
	public KhachHang getKhachHang() {
		KhachHang khachHang = new KhachHang();
		if(isLogined() && getUserLogined().getIdKhachHang() != null) {
			khachHang = khachHangService.getById(getUserLogined().getIdKhachHang());
		}
		return khachHang;
	}

}
