package com.devpro.JavaWeb.controller.administrator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.TaiKhoanSearch;
import com.devpro.JavaWeb.dto.TaiKhoanUpdate;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.model.TaiKhoan;
import com.devpro.JavaWeb.services.impl.KhachHangService;
import com.devpro.JavaWeb.services.impl.UserDetailsServiceImpl;

@Controller
public class AdminQuanLyTaiKhoan extends BaseController{
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	KhachHangService khachHangService;
	
	TaiKhoanSearch taiKhoanSearch = new TaiKhoanSearch();
	
	@RequestMapping(value = {"/admin/quan-ly-tai-khoan"}, method = RequestMethod.GET)
	public String quanLyTaiKhoan(final HttpServletRequest request,
			final HttpServletResponse response,
			final Model model
			) throws IOException {
		
		taiKhoanSearch.setPage(1);
		taiKhoanSearch.setSizeOfPage(6);
		taiKhoanSearch.setTenKhachHang(request.getParameter("tenkhachhang"));
		List<KhachHang> khachHangs = khachHangService.findAll();

		model.addAttribute("taiKhoans", userDetailsServiceImpl.searchTaiKhoan(taiKhoanSearch));
		
		model.addAttribute("khachHangs", khachHangs);
		return "administrator/quanlytaikhoan";
	}
	
	@RequestMapping(value = {"/admin/quan-ly-tai-khoan"}, method = RequestMethod.POST)
	public String quanLyTaiKhoanPOST(final HttpServletRequest request,
			final HttpServletResponse response,
			final Model model) {
		Integer soTrang = Integer.parseInt(request.getParameter("sotrang"));
		taiKhoanSearch.setPage(soTrang);
		List<KhachHang> khachHangs = khachHangService.findAll();

		model.addAttribute("taiKhoans", userDetailsServiceImpl.searchTaiKhoan(taiKhoanSearch));
		
		model.addAttribute("khachHangs", khachHangs);
		
		return "administrator/quanlytaikhoan";
	}	
	
	@RequestMapping(value = {"/admin/xoa-tai-khoan"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> xoaTaiKhoan(final HttpServletRequest request,
			final HttpServletResponse response,
			final Model model,
			@RequestBody TaiKhoanUpdate taiKhoan) {
		TaiKhoan t = userDetailsServiceImpl.getById(taiKhoan.getId());
		t.setStatus(taiKhoan.getStastus());
		userDetailsServiceImpl.xoaTaiKhoan(t);
		Map<String, Object> result = new HashMap<String, Object>();
		if(taiKhoan.getStastus() == 0) {
			result.put("message", "Xóa thành công");
		} else {
			result.put("message", "Kích hoạt thành công");
		}
		return ResponseEntity.ok(result);
	}

}
