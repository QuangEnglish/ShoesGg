package com.devpro.JavaWeb.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.services.impl.SanPhamService;

@Controller
public class TimKiemSanPhamController extends BaseController {
	
	
	@Autowired
	SanPhamService sanPhamService;
	
	SanPhamSearch sanPhamSearch = new SanPhamSearch();
	
	String tenSp = "";
	int soSP = 0;
	
	@RequestMapping(value = {"/tim-kiem-san-pham"}, method = RequestMethod.GET)
	public String timKiemGet(final Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		tenSp = request.getParameter("tensanpham");
		sanPhamSearch.setKeyword(tenSp);
		sanPhamSearch.setStatus(1+"");
		sanPhamSearch.setPage(1);
		sanPhamSearch.setSizeOfPage(6);
		soSP = sanPhamService.getEntitiesByNativeSQL("select * from san_pham where ten_sp like '%" + tenSp + "%'").size();
		model.addAttribute("sanPhams", sanPhamService.timKiemTatCaSanPham(sanPhamSearch));
		model.addAttribute("tenSp", tenSp);
		model.addAttribute("soSP", soSP);
		
		return "customer/timkiemsanpham";
	}
	
	@RequestMapping(value = {"/tim-kiem-san-pham"}, method = RequestMethod.POST)
	public String timKiemPost(final Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		sanPhamSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		model.addAttribute("sanPhams", sanPhamService.timKiemTatCaSanPham(sanPhamSearch));
		model.addAttribute("tenSp", tenSp);
		model.addAttribute("soSP", soSP);
		
		return "customer/timkiemsanpham";
	}

}
