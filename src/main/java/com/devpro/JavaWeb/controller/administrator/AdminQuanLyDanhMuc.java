package com.devpro.JavaWeb.controller.administrator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.DanhMucSearch;
import com.devpro.JavaWeb.model.DanhMucPhuKien;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac1;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac2;
import com.devpro.JavaWeb.services.PagerData;
import com.devpro.JavaWeb.services.impl.DanhMucBac1Service;
import com.devpro.JavaWeb.services.impl.DanhMucBac2Service;
import com.devpro.JavaWeb.services.impl.DanhMucPhuKienService;


@Controller
public class AdminQuanLyDanhMuc extends BaseController{

	@Autowired
	DanhMucBac2Service danhMucBac2Service;
	
	@Autowired
	DanhMucPhuKienService danhMucPhuKienService;
	
	@Autowired
	DanhMucBac1Service danhMucBac1Service;
	
	DanhMucSearch danhMucSearch = new DanhMucSearch();
	
	@RequestMapping(value = {"/admin/quan-ly-danh-muc-san-pham"}, method =  RequestMethod.GET)
	public String quanLyDanhMucSanPhamGET(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) {
		XoaDuLieu(model);
		danhMucSearch.setTenDanhMuc(request.getParameter("tendanhmuc"));
		danhMucSearch.setPage(1);
		danhMucSearch.setSizeOfPage(10);
		model.addAttribute("link", "admin/quan-ly-danh-muc-san-pham");
		model.addAttribute("tieude", "Danh mục sản phẩm");
		model.addAttribute("danhMucSPB2", danhMucBac2Service.searchDanhMucBac2(danhMucSearch));
		return "administrator/quanlydanhmucsanpham";
	}
	
	
	@RequestMapping(value = {"/admin/quan-ly-danh-muc-san-pham"}, method = RequestMethod.POST)
	public String quanLyDanhMucSanPhamPOST(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		danhMucSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		model.addAttribute("link", "admin/quan-ly-danh-muc-san-pham");
		model.addAttribute("tieude", "Danh mục sản phẩm");
		model.addAttribute("danhMucSPB2", danhMucBac2Service.searchDanhMucBac2(danhMucSearch));
		return "administrator/quanlydanhmucsanpham";
	}
	
	
	@RequestMapping(value = {"/admin/quan-ly-danh-muc-phu-kien"}, method =  RequestMethod.GET)
	public String quanLyDanhMucPhuKien(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) {
		XoaDuLieu(model);
		model.addAttribute("link", "/admin/quan-ly-danh-muc-phu-kien");
		model.addAttribute("tieude", "Danh mục phụ kiện");
		
		danhMucSearch.setPage(1);
		PagerData<DanhMucPhuKien> daPagerData = danhMucPhuKienService.SearchPhuKien(danhMucSearch);
		
		model.addAttribute("danhMucPK", daPagerData);
		PagerData<DanhMucPhuKien> data = new PagerData<DanhMucPhuKien>();
		data.setCurrentPage(daPagerData.getCurrentPage());
		data.setSizeOfPage(daPagerData.getSizeOfPage());
		data.setTotalItems(daPagerData.getTotalItems());
		model.addAttribute("danhMucSPB2", data);
		
		return "administrator/quanlydanhmucsanpham";
	}
	
	
	@RequestMapping(value = {"/admin/quan-ly-danh-muc-phu-kien"}, method =  RequestMethod.POST)
	public String quanLyDanhMucPhuKienPOST(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) {
		
		model.addAttribute("link", "/admin/quan-ly-danh-muc-phu-kien");
		model.addAttribute("tieude", "Danh mục phụ kiện");
		
		
		danhMucSearch.setPage(Integer.parseInt(request.getParameter("sotrang")));
		PagerData<DanhMucPhuKien> daPagerData = danhMucPhuKienService.SearchPhuKien(danhMucSearch);
		model.addAttribute("danhMucPK", daPagerData);
		PagerData<DanhMucPhuKien> data = daPagerData;
		data.setData(null);
		model.addAttribute("danhMucSPB2", data);
		return "administrator/quanlydanhmucsanpham";
	}
	
	public void XoaDuLieu(Model model) {
		
		model.addAttribute("danhMucSPB2", null);
		model.addAttribute("danhMucPK", null);
	}
	
	@RequestMapping(value = "/admin/them-danh-muc-san-pham", method = RequestMethod.POST)
	public String ThemDanhMucSanPham(final Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		DanhMucSanPhamBac2 dBac2 = new DanhMucSanPhamBac2();
		Integer idDanhMucSanPham = null;
		if(!StringUtils.isEmpty(request.getParameter("iddanhmuc"))) {
			idDanhMucSanPham = Integer.parseInt(request.getParameter("iddanhmuc"));
			dBac2.setId(idDanhMucSanPham);
		}
		
		dBac2.setTenDanhMuc(request.getParameter("tendanhmuc"));
		if(!request.getParameter("danhmucbac1").equals("")) {
			DanhMucSanPhamBac1 dBac1 = danhMucBac1Service.getById(Integer.parseInt(request.getParameter("danhmucbac1")));
			dBac2.setDanhMucSanPhamBac1(dBac1);
			
			danhMucBac2Service.saveOrUpdate(dBac2);
		}
		return "redirect:/admin/quan-ly-danh-muc-san-pham";
		
	}
	
	@RequestMapping(value = "/admin/them-sua-danh-muc-phu-kien", method = RequestMethod.POST)
	public String themSuaDanhMucPK(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) {
		
		DanhMucPhuKien danhKien = new DanhMucPhuKien();
		if(!request.getParameter("iddanhmuc").equals("")) {
			danhKien.setId(Integer.parseInt(request.getParameter("iddanhmuc")));
		}
		
		danhKien.setTenDanhMuc(request.getParameter("tendanhmucpk"));
		danhMucPhuKienService.saveOrUpdate(danhKien);
		return "redirect:/admin/quan-ly-danh-muc-phu-kien";
	}
	
	@RequestMapping(value = "/admin/xoa-danh-muc-san-pham", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> xoaDanhMucSanPham(final Model model ,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody DanhMucSanPhamBac2 danhPhamBac2){
		DanhMucSanPhamBac2 bac2Xoa = danhMucBac2Service.getById(danhPhamBac2.getId());
		bac2Xoa.setStatus(0);
		danhMucBac2Service.saveOrUpdate(bac2Xoa);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("message", "Xóa danh mục sản phẩm thành công");
		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value = "/admin/xoa-danh-muc-phu-kien", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> xoaDanhMucPhuKien(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody DanhMucPhuKien danhMucPhuKienXoa){
		DanhMucPhuKien phuKienXoa = danhMucPhuKienService.getById(danhMucPhuKienXoa.getId());
		phuKienXoa.setStatus(0);
		danhMucPhuKienService.saveOrUpdate(phuKienXoa);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("message", "Xóa thành công");
		return ResponseEntity.ok(jsonResult);
	}
	
	
}

