package com.devpro.JavaWeb.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.HoaDonSearch;
import com.devpro.JavaWeb.model.HoaDon;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.services.impl.HoaDonService;
import com.devpro.JavaWeb.services.impl.KhachHangService;

@Controller
public class LichSuMuaHangController extends BaseController{
	
	@Autowired
	KhachHangService khachHangService;
	
	
	@Autowired
	HoaDonService hoaDonService;
	
	HoaDonSearch hoaDonSearch = new HoaDonSearch();
	
	@RequestMapping(value = {"/lich-su-mua-hang"}, method = RequestMethod.GET)
	public String lichSuMuaHangGET(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		if(isLogined()) {
			hoaDonSearch.setSizeOfPage(6);
			hoaDonSearch.setPage(1);
			hoaDonSearch.setIdTaiKhoan(getUserLogined().getId());
			model.addAttribute("hoaDons", hoaDonService.searchHoaDon(hoaDonSearch));
		} else {
			model.addAttribute("hoaDons", null);
		}
		
		
		return "customer/lichsumuahang";
	}
	
	@RequestMapping(value = "/lich-su-mua-hang", method = RequestMethod.POST)
	public String lichSuMuaHangPost(final Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		hoaDonSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		model.addAttribute("hoaDons", hoaDonService.searchHoaDon(hoaDonSearch));
		return "customer/lichsumuahang";
	}
}
