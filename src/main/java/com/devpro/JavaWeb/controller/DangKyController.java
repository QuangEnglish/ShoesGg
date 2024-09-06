package com.devpro.JavaWeb.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.model.Role;
import com.devpro.JavaWeb.model.TaiKhoan;
import com.devpro.JavaWeb.services.impl.KhachHangService;
import com.devpro.JavaWeb.services.impl.RoleService;
import com.devpro.JavaWeb.services.impl.UserDetailsServiceImpl;

@Controller
public class DangKyController extends BaseController{

	
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.GET)
	public String dangKyGET(final Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		return "dangky";
	}
	
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.POST)
	public String dangKyPOST(final Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		Set<Role> roles = new HashSet<Role>(roleService.getEntitiesByNativeSQL("select * from role where name = 'GUEST'"));
		
		KhachHang khachHang = new KhachHang();
		khachHang.setHoTen(request.getParameter("hoten"));
		khachHang.setSoDienThoai(request.getParameter("sodienthoai"));
		khachHang.setEmail(request.getParameter("email"));
		
		KhachHang khachHangUpdate = khachHangService.saveOrUpdate(khachHang);
		
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setUsername(request.getParameter("tendangnhap"));
		taiKhoan.setPassword(new BCryptPasswordEncoder(4).encode(request.getParameter("matkhau")));
		taiKhoan.setIdKhachHang(khachHangUpdate.getId());
		taiKhoan.setRoles(roles);
		taiKhoan.setEmail(request.getParameter("email"));
		userDetailsServiceImpl.saveOrUpdate(taiKhoan);
		
		return "redirect:/login";
	}
	
}
