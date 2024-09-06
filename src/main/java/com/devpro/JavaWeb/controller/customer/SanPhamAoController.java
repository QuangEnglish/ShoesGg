package com.devpro.JavaWeb.controller.customer;

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
import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac2;
import com.devpro.JavaWeb.services.impl.DanhMucBac2Service;
import com.devpro.JavaWeb.services.impl.SanPhamService;
import com.ibm.icu.math.BigDecimal;

@Controller
public class SanPhamAoController extends BaseController {

	@Autowired
	DanhMucBac2Service danhMucBac2Service;
	
	@Autowired
	SanPhamService sanPhamService;
	
	SanPhamSearch sanPhamSearch = new SanPhamSearch();
	
	@RequestMapping(value = {"/san-pham-ao"}, method = RequestMethod.GET)
	public String sanPhamGfet(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException{
		String tenDM = request.getParameter("tendm");
		DanhMucSanPhamBac2 danhMucSanPhamBac2 = danhMucBac2Service.getEntityByNativeSQL("SELECT * FROM danh_muc_san_pham_bac2 where ten_dm = '"+tenDM+"'");
		model.addAttribute("danhMucSanPhamBac",danhMucSanPhamBac2);
		
		sanPhamSearch.setStatus(1+"");
		sanPhamSearch.setPage(1);
		if(danhMucSanPhamBac2 != null && danhMucSanPhamBac2.getId()!=null){
			sanPhamSearch.setDanhMucId(danhMucSanPhamBac2.getId()+"");
		}
		sanPhamSearch.setSizeOfPage(12);
		sanPhamSearch.setTenSp(request.getParameter("tensp"));
		if(!StringUtils.isEmpty(request.getParameter("pricemin"))) {
			sanPhamSearch.setMinPrice(new BigDecimal(request.getParameter("pricemin")));
		}
		if(!StringUtils.isEmpty(request.getParameter("pricemax"))) {
			sanPhamSearch.setMaxPrice(new BigDecimal(request.getParameter("pricemax")));
		}
		
		model.addAttribute("tendm", tenDM);
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, false));
		return "customer/sanphamao";
	}
	
	
	@RequestMapping(value = {"/san-pham-ao"}, method = RequestMethod.POST)
	public String sanPhamPost(final Model model,
	HttpServletRequest request,
	HttpServletResponse response)
	throws IOException{
		int soTrang = 1;
		try {
			soTrang = Integer.parseInt(request.getParameter("sotrang"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		sanPhamSearch.setPage(soTrang);
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, false));
		return "customer/sanphamao";
	}
	
}
