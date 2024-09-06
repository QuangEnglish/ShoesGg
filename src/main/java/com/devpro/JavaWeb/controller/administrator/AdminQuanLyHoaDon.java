package com.devpro.JavaWeb.controller.administrator;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.HoaDonSearch;
import com.devpro.JavaWeb.model.HoaDon;
import com.devpro.JavaWeb.services.PagerData;
import com.devpro.JavaWeb.services.impl.HoaDonService;
import com.devpro.JavaWeb.services.utils.Utils;

@Controller
public class AdminQuanLyHoaDon extends BaseController{

	@Autowired
	HoaDonService hoaDonService;
	
	HoaDonSearch hoaDonSearch = new HoaDonSearch();
	
	@RequestMapping(value = {"/admin/quan-ly-hoa-don"}, method = RequestMethod.GET)
	public String quanLyHoaDon(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		hoaDonSearch.setTenKhachHang(request.getParameter("tenkhachhang"));
		if(StringUtils.hasText(request.getParameter("paymentMetod"))) {
			hoaDonSearch.setPaymentMethod(Integer.parseInt(request.getParameter("paymentMetod")));
		}
		if(StringUtils.hasText(request.getParameter("paymentStatus"))) {
			hoaDonSearch.setPaymentStatus(Integer.parseInt(request.getParameter("paymentStatus")));
		}
		if(StringUtils.hasText(request.getParameter("status"))) {
			hoaDonSearch.setStatus(Integer.parseInt(request.getParameter("status")));
		}
		hoaDonSearch.setSizeOfPage(6);
		hoaDonSearch.setPage(1);
		
		PagerData<HoaDon> hoaDons = hoaDonService.searchHoaDon(hoaDonSearch);
		for(HoaDon hoaDon : hoaDons.getData()) {
			hoaDon.setStatusString(Utils.convertStatus(hoaDon.getStatus()));
		}
		model.addAttribute("hoaDonSearch", hoaDonSearch);
		model.addAttribute("hoaDons", hoaDons);
		model.addAttribute("hoaDonSearchPaymentMethod", hoaDonSearch.getPaymentMethod());
		return "administrator/quanlyhoadon";
	}
	
	@RequestMapping(value = {"/admin/quan-ly-hoa-don"}, method = RequestMethod.POST)
	public String quanLyHoaDonPOST(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		hoaDonSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		model.addAttribute("hoaDonSearch", hoaDonSearch);
		model.addAttribute("hoaDonSearchPaymentMethod", hoaDonSearch.getPaymentMethod());
		PagerData<HoaDon> hoaDons = hoaDonService.searchHoaDon(hoaDonSearch);
		for(HoaDon hoaDon : hoaDons.getData()) {
			hoaDon.setStatusString(Utils.convertStatus(hoaDon.getStatus()));
		}
		model.addAttribute("hoaDons", hoaDons);
		return "administrator/quanlyhoadon";
	}
}
