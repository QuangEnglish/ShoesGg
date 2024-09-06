package com.devpro.JavaWeb.controller.administrator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.model.HoaDon;
import com.devpro.JavaWeb.services.impl.HoaDonService;
import com.devpro.JavaWeb.services.utils.Utils;

@Controller
public class AdminChiTietHoaDon {
	
	@Autowired
	HoaDonService hoaDonService;

	@RequestMapping(value = {"/admin/chi-tiet-hoa-don"}, method = RequestMethod.GET)
	public String chiTietHoaDon(final Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		Integer idhd = Integer.parseInt(request.getParameter("idhd"));
		HoaDon hoaDon = hoaDonService.getById(idhd);
		model.addAttribute("hoaDon", hoaDon);
		model.addAttribute("status", Utils.convertStatus(hoaDon.getStatus()));
		return "chitiethoadon";
	}
	
	@RequestMapping(value = {"/admin/bill/chang-status"}, method = RequestMethod.GET)
	public String thayDoiTrangThai(
			final Model model,
			HttpServletRequest request,
			HttpServletResponse response
			) {
		Integer id = Integer.parseInt(request.getParameter("idhd"));
		Integer status = Integer.parseInt(request.getParameter("status"));
		HoaDon hoaDon = hoaDonService.getById(id);
		hoaDon.setStatus(status);
		if(status == -1 || status == -2) {
			if(hoaDon.getPaymentMethod() == Utils.PaymentMethodType.NOT_PAY) {
				hoaDon.setPaymentMethod(Utils.PaymentMethodType.CANCELED);
			} else if (hoaDon.getPaymentMethod() == Utils.PaymentMethodType.PAY) {
				hoaDon.setPaymentMethod(Utils.PaymentMethodType.REFUNDED);
			}
		}
		hoaDonService.saveOrUpdate(hoaDon);
		return "redirect:/admin/chi-tiet-hoa-don?idhd=" + id;
	}
	
	
	

}
