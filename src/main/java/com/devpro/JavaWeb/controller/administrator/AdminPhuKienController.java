package com.devpro.JavaWeb.controller.administrator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.services.impl.DanhMucPhuKienService;
import com.devpro.JavaWeb.services.impl.SanPhamService;


@Controller
public class AdminPhuKienController extends BaseController{
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucPhuKienService danhMucPhuKienService;
	
	SanPhamSearch searchPhuKien = new SanPhamSearch();
	
	int index = 0;
	
	@RequestMapping(value = {"/admin/quan-ly-phu-kien"}, method = RequestMethod.GET)
	public String BaoTriPhuKien(Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		
		int so = 1;
		try {
			so = Integer.parseInt(request.getParameter("sotrang"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		searchPhuKien.setKeyword(request.getParameter("timkiemten"));
		searchPhuKien.setDanhMucId(request.getParameter("timkiemloaipk"));
		
		searchPhuKien.setPage(so);
		searchPhuKien.setSizeOfPage(6);
		model.addAttribute("phuKiens", sanPhamService.searchPhuKien(searchPhuKien));
		
		index = so * 6 - 6;
		model.addAttribute("index", index);
		model.addAttribute("searchPhuKien", searchPhuKien);
		return "administrator/quanlyphukien";
	}
	
	@RequestMapping(value = {"/admin/quan-ly-phu-kien"}, method = RequestMethod.POST)
	public String baoTriPhuKienPost(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException{
		int so = 1;
		try {
			so = Integer.parseInt(request.getParameter("sotrang"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		searchPhuKien.setPage(so);
		
		model.addAttribute("phuKiens", sanPhamService.searchPhuKien(searchPhuKien));
		
		index = so * 6 - 6;
		model.addAttribute("index", index);
		model.addAttribute("searchPhuKien", searchPhuKien);
		return "administrator/quanlyphukien";
	}
	
	@RequestMapping(value = {"/admin/them-sua-phu-kien"}, method = RequestMethod.GET)
	public String themSuaPhuKien(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) {
		Integer id = null;
		try {
			id = Integer.parseInt(request.getParameter("idsp"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		SanPham sanPhamPhuKien = new SanPham();
		if(id != null) {
			sanPhamPhuKien = sanPhamService.getById(id);
		}
		model.addAttribute("phuKien", sanPhamPhuKien);
		return "administrator/themphukien";
	}
	
	@RequestMapping(value = {"/admin/them-phu-kien-spring"}, method = RequestMethod.POST)
	public String themSuaPhuKienPost(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute SanPham phuKien,
			@RequestParam("anhSanPham") MultipartFile anhSanPham) throws IllegalStateException, IOException {
		if(request.getParameter("nutchon").equals("Hủy")) {
			return "redirect:/admin/quan-ly-phu-kien";
		}
		
		if(phuKien.getId() == null || phuKien.getId() <= 0) {
			sanPhamService.themSanPham(phuKien, anhSanPham);
		} else {
			sanPhamService.updateSanPham(phuKien, anhSanPham);
		}
		return "redirect:/admin/quan-ly-phu-kien";
	}
	
	@RequestMapping(value = {"/admin/xoa-phu-kien"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Map<String, Object>> xoaPhuKien(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody SanPham phuKienXoa)
	throws IOException {
		
		sanPhamService.deleteSanPham(phuKienXoa);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("message", "Xóa thành công phụ kiện ");
		return ResponseEntity.ok(jsonResult);
	}
	
	
}
