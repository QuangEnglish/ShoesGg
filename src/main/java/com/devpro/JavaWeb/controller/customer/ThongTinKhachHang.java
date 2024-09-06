package com.devpro.JavaWeb.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.services.impl.KhachHangService;

@Controller
public class ThongTinKhachHang extends BaseController {
	
	@Autowired
	KhachHangService khachHangService;
	
	@RequestMapping(value = {"/thong-tin-khach-hang"}, method = RequestMethod.GET)
	public String thongTinKhachHang(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		
		return "customer/thongtinkhachhang";
	}
	
	
	@RequestMapping(value = {"/thong-tin-khach-hang"}, method = RequestMethod.POST)
	public String thongTinKhachHangPOST(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		KhachHang khachHang = getKhachHang();
		khachHang.setHoTen(request.getParameter("hoten"));
		khachHang.setEmail(request.getParameter("email"));
		khachHang.setSoDienThoai(request.getParameter("sodienthoai"));
		khachHang.setGioiTinh(request.getParameter("gioitinh"));
		khachHang.setDiaChi(request.getParameter("diachi"));
		khachHangService.saveOrUpdate(khachHang);
		
		
		return "customer/thongtinkhachhang";
	}
	
	

}
