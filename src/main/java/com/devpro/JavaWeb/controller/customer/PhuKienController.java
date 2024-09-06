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
import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.model.DanhMucPhuKien;
import com.devpro.JavaWeb.services.impl.DanhMucPhuKienService;
import com.devpro.JavaWeb.services.impl.SanPhamService;


@Controller
public class PhuKienController extends BaseController{
	
	@Autowired
	DanhMucPhuKienService danhMucPhuKienService;
	
	
	@Autowired
	SanPhamService sanPhamService;
	
	SanPhamSearch sanPhamSearch = new SanPhamSearch();
	
	DanhMucPhuKien danhMucPhuKien = new DanhMucPhuKien();

	@RequestMapping(value = {"/danh-sach-phu-kien"}, method = RequestMethod.GET)
	public String danhSachPhuKien(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		String tenDMPK = request.getParameter("tendmpk");
		
		danhMucPhuKien = danhMucPhuKienService.getEntityByNativeSQL("SELECT * FROM danh_muc_phu_kien WHERE ten_dm = '" + tenDMPK + "'");
		model.addAttribute("danhMucPhuKien1", danhMucPhuKien);
		sanPhamSearch.setDanhMucId(danhMucPhuKien.getId() + "");
		sanPhamSearch.setPage(1);
		sanPhamSearch.setSizeOfPage(12);
		sanPhamSearch.setStatus(1+"");
		model.addAttribute("phuKiens", sanPhamService.searchPhuKien(sanPhamSearch));
		
		return "customer/danhsachphukien";
	}
	
	@RequestMapping(value = {"/danh-sach-phu-kien"}, method = RequestMethod.POST)
	public String danhSachPhuKienPost(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		sanPhamSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		model.addAttribute("danhMucPhuKien1", danhMucPhuKien);
		model.addAttribute("phuKiens", sanPhamService.searchPhuKien(sanPhamSearch));
		
		return "customer/danhsachphukien";
	}
}
	
