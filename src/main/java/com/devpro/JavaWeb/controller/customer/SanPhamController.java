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
import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac1;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac2;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.services.PagerData;
import com.devpro.JavaWeb.services.impl.DanhMucBac1Service;
import com.devpro.JavaWeb.services.impl.DanhMucBac2Service;
import com.devpro.JavaWeb.services.impl.SanPhamService;

@Controller
public class SanPhamController extends BaseController {

	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private DanhMucBac2Service danhMucBac2Service;
	
	@Autowired
	private DanhMucBac1Service danhMucBac1Service;
	
	private SanPhamSearch sanPhamSearch = new SanPhamSearch();
	
	private List<DanhMucSanPhamBac2> bac2s = new ArrayList<DanhMucSanPhamBac2>();
	
	@RequestMapping(value = {"/san-pham"}, method = RequestMethod.GET)
	public String sanPhamGet(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException{
		String tenDM1 = request.getParameter("tenloai");
		DanhMucSanPhamBac1 danhMucSanPhamBac1 = danhMucBac1Service.getEntityByNativeSQL("select * from danh_muc_san_pham_bac1 where ten_dm = '" + tenDM1 + "'");
		model.addAttribute("tenDM1", tenDM1);
		if(request.getParameter("tendm") != null) {
			
			DanhMucSanPhamBac2 danhMucSanPhamBac2 = danhMucBac2Service.getEntityByNativeSQL("SELECT * FROM danh_muc_san_pham_bac2 where ten_dm = '" + request.getParameter("tendm")+ "'");
			sanPhamSearch.setDanhMucId(danhMucSanPhamBac2.getId() + "");
		}
		
		sanPhamSearch.setPage(1);
		sanPhamSearch.setSizeOfPage(24);
		sanPhamSearch.setStatus(1+"");

		if(danhMucSanPhamBac1 != null && danhMucSanPhamBac1.getId()!=null){
			bac2s = danhMucBac2Service.getEntitiesByNativeSQL("SELECT * FROM danh_muc_san_pham_bac2 where id_dm_b1 = " + danhMucSanPhamBac1.getId());
		}

		model.addAttribute("danhmucb2", bac2s);
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, false));
		return "customer/sanpham";
	}
	
	@RequestMapping(value = {"/san-pham"}, method = RequestMethod.POST)
	public String sanPhamPost(final Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		
		sanPhamSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, false));
		
		return "customer/sanpham";
	}
}
