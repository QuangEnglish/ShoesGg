package com.devpro.JavaWeb.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.services.PagerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.services.impl.SanPhamService;

@Controller
public class TrangChuController extends BaseController {

	@Autowired
	SanPhamService sanPhamService;

	SanPhamSearch sanPhamSearch = new SanPhamSearch();


	@RequestMapping(value = {"/trang-chu"}, method = RequestMethod.GET)
	public String trangchu(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	 {
		
//		List<SanPham> sanPhams = new ArrayList<SanPham>();
//		sanPhams = sanPhamService.getEntitiesByNativeSQL("select * from san_pham where id_dm_pk is null order by id desc limit 16");

		int soTrang = 1;
//		soTrang = Integer.parseInt(request.getParameter("sotrang"));
		sanPhamSearch.setPage(soTrang);
		sanPhamSearch.setSizeOfPage(8);
		 PagerData<SanPham> sanPhamPagerData = sanPhamService.searchSanPham(sanPhamSearch, false);
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, false));
		
//		model.addAttribute("sanPhams", sanPhams);
		
		return "customer/trangchu";
	}

	@RequestMapping(value = {"/trang-chu"}, method = RequestMethod.POST)
	public String sanPhamPost(final Model model,
							  HttpServletRequest request,
							  HttpServletResponse response)
	{
		int soTrang = 1;
		try {
			soTrang = Integer.parseInt(request.getParameter("sotrang"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		sanPhamSearch.setPage(soTrang);
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, false));
		return "customer/trangchu";
	}

}
