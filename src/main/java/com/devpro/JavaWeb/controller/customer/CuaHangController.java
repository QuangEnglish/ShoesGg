package com.devpro.JavaWeb.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.model.CuaHang;
import com.devpro.JavaWeb.services.impl.CuaHangService;

@Controller
public class CuaHangController extends BaseController {
	
	@Autowired
	CuaHangService cuaHangService;

	String tenCuaHang = "";
	
	@RequestMapping(value = "/cua-hang", method = RequestMethod.GET)
	public String cuaHangGET(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse reaHttpServletResponse)
	throws IOException {
//		tenCuaHang = request.getParameter("diachicuahang");
//		String dieuKien = "";
//		if(tenCuaHang.equals("") == false) {
//			dieuKien = " and (dia_chi_cu_the like like '%" + tenCuaHang + "%' or ten_cua_hang like '%" + tenCuaHang + "%')";
//		}
		List<CuaHang> cuaHangs = cuaHangService.getEntitiesByNativeSQL("select * from cua_hang where 1 = 1");
		model.addAttribute("cuaHangs", cuaHangs);
		model.addAttribute("tenCuaHang", tenCuaHang);
		return "customer/cuahang";	
	}
	
	@RequestMapping(value = "/cua-hang", method = RequestMethod.POST)
	public String cuaHangPOST(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse reaHttpServletResponse)
	throws IOException {
		tenCuaHang = request.getParameter("diachicuahang");
		String dieuKien = "";
		if(!tenCuaHang.equals("")) {
			dieuKien = " and (dia_chi_cu_the like '%" + tenCuaHang + "%' or ten_cua_hang like '%" + tenCuaHang + "%')";
		}
		List<CuaHang> cuaHangs = cuaHangService.getEntitiesByNativeSQL("select * from cua_hang where 1 = 1" + dieuKien);
		model.addAttribute("cuaHangs", cuaHangs);
		model.addAttribute("tenCuaHang", tenCuaHang);
		return "customer/cuahang";	
	}
	
}
