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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac1;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac2;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.services.impl.DanhMucBac1Service;
import com.devpro.JavaWeb.services.impl.DanhMucBac2Service;
import com.devpro.JavaWeb.services.impl.SanPhamService;
import com.ibm.icu.math.BigDecimal;

import antlr.collections.List;


@Controller
public class AdminTrangChuController extends BaseController{
	@Autowired
	SanPhamService sanPhamService;
	
	
	@Autowired
	DanhMucBac1Service danhMucBac1Service;
	
	@Autowired
	DanhMucBac2Service danhMucBac2Service;
	
	SanPhamSearch sanPhamSearch = new SanPhamSearch();
	
	int index = 0;
	int soTrang;
	@RequestMapping(value = {"/admin/trang-chu"}, method = RequestMethod.GET)
	public String adminTrangChu(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		int so = 1;
		try {
			so = Integer.parseInt(request.getParameter("sotrang"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		sanPhamSearch.setKeyword(request.getParameter("timkiemten"));
		sanPhamSearch.setDanhMucId(request.getParameter("timkiemloaisp"));
		sanPhamSearch.setPhienBan(request.getParameter("timkiemphienban"));
		if(
				StringUtils.hasText(request.getParameter("timkiemtrangthai"))
		) {
			sanPhamSearch.setStatusSearch(Integer.parseInt(request.getParameter("timkiemtrangthai")));
		}
		if(!StringUtils.isEmpty(request.getParameter("pricemin"))) {
			sanPhamSearch.setMinPrice(new BigDecimal(request.getParameter("pricemin")));
		}
		if(!StringUtils.isEmpty(request.getParameter("pricemax"))) {
			sanPhamSearch.setMaxPrice(new BigDecimal(request.getParameter("pricemax")));
		}
		sanPhamSearch.setPage(so);
		sanPhamSearch.setSizeOfPage(6);
		//List<SanPham> liPhams = sanPhamService.searchProduct(sanPhamSearch);
//		int soSanPham = liPhams.size();
//		soTrang = soSanPham / 6;
//		if(soSanPham % 6 != 0) {
//			soTrang++;
//		}
//		model.addAttribute("sotrang", soTrang);
//		model.addAttribute("index", index);
//		List<SanPham> sanPhams = sanPhamService.searchProductPhanTrang(sanPhamSearch, 1); //sanPhamService.getEntitiesByNativeSQL("select * from( select *, row_number() over (order by id desc) as r from san_Pham) as tam where r between 1 and 6");
//		model.addAttribute("sanPhams", sanPhams);
//		model.addAttribute("sanPhamSearch",sanPhamSearch);
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, true));
		index = so*6 - 6;
		model.addAttribute("sanPhamSearch",sanPhamSearch);
		model.addAttribute("index", index);
		return "administrator/trangchu";
	}
	
	@RequestMapping(value = {"/admin/trang-chu"}, method = RequestMethod.POST)
	public String phanTrang(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) {
		
		int so = Integer.parseInt(request.getParameter("sotrang"));
		sanPhamSearch.setPage(so);
		System.out.println(so);
		index = so*6 - 6;
		model.addAttribute("sotrang", soTrang);
		model.addAttribute("index", index);
//		List<SanPham> sanPhams = sanPhamService.searchProductPhanTrang(sanPhamSearch, so); //sanPhamService.getEntitiesByNativeSQL("select * from( select *, row_number() over (order by id desc) as r from san_Pham) as tam where r between "+ (so*6-5) +" and " + (so * 6));
		model.addAttribute("sanPhams", sanPhamService.searchSanPham(sanPhamSearch, true));
		//model.addAttribute("sanPhamSearch",sanPhamSearch);
		model.addAttribute("sanPhamSearch",sanPhamSearch);
		return "administrator/trangchu";
	}
	
//	@RequestMapping(value = {"/admin/trang-chu-search"}, method = RequestMethod.POST)
//	public String searchSanPham(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response) {
//		SanPhamSearch sanPhamSearch = new SanPhamSearch();
//		sanPhamSearch.setKeyword(request.getParameter("timkiemten"));
//		sanPhamSearch.setDanhMucId(request.getParameter("timkiemloaisp"));
//		model.addAttribute("sanPhams", sanPhamService.searchProduct(sanPhamSearch));
//		return "administrator/trangchu";
//	}
	
	@RequestMapping(value = {"/admin/them-san-pham"}, method = RequestMethod.GET)
	public String adminThemSanPham(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		
		
		SanPham sanPham1 = new SanPham();
		model.addAttribute("sanPham" ,sanPham1);
//		List<DanhMucSanPhamBac2> danhMucSanPhamBac2 = danhMucBac2Service.findAll();
//		model.addAttribute("danhMucSanPhamBac2", danhMucSanPhamBac2);
		model.addAttribute("title", "Thêm sản phẩm");
		model.addAttribute("isRead", false);
		return "administrator/themsanpham";
	}
	
	
	@RequestMapping(value = "/admin/them-san-pham-spring", method = RequestMethod.POST)
	public String adminThemSanPhamPost(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("sanPham") SanPham sanPham,
			@RequestParam("anhSanPham") MultipartFile anhSanPham) throws IOException {
		if(request.getParameter("nutchon").equals("Hủy")) {
			return "redirect:/admin/trang-chu";
		}
	
		if(sanPham.getId() == null || sanPham.getId() <= 0) {
			sanPhamService.themSanPham(sanPham, anhSanPham);
		} else {
			sanPhamService.updateSanPham(sanPham, anhSanPham);
		}
		
		return "redirect:/admin/trang-chu";
	}
	
	
	@RequestMapping(value = "admin/sua-san-pham", method = RequestMethod.GET)
	public String suaSanPhamGet(Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
//		List<DanhMucSanPhamBac2> danhMucSanPhamBac2 = danhMucBac2Service.findAll();
//		model.addAttribute("danhMucSanPhamBac2", danhMucSanPhamBac2);
		SanPham sanPham = sanPhamService.getById(id);
		model.addAttribute("title", "Cập nhật sản phẩm");
		model.addAttribute("isRead", false);
		model.addAttribute("sanPham" ,sanPham);
		
		
		return "administrator/themsanpham";
	}
	
	@RequestMapping(value = "admin/chi-tiet", method = RequestMethod.GET)
	public String chiTietSanPhamGet(Model model,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
//		List<DanhMucSanPhamBac2> danhMucSanPhamBac2 = danhMucBac2Service.findAll();
//		model.addAttribute("danhMucSanPhamBac2", danhMucSanPhamBac2);
		SanPham sanPham = sanPhamService.getById(id);
		model.addAttribute("title", "Chi tiết sản phẩm");
		model.addAttribute("isRead", true);
		model.addAttribute("sanPham" ,sanPham);
		
		
		return "administrator/themsanpham";
	}
	
//	@RequestMapping(value = {"/admin/chon-loai-sp"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<DanhMucSanPhamBac1> chonLoaiSanPham(final Model model,
//			final HttpServletRequest request,
//			final @RequestBody DanhMucSanPhamBac1 danhMucSanPhamBac1,
//			final HttpServletResponse response)
//	throws IOException {
//		DanhMucSanPhamBac1 danhBac1 = danhMucBac1Service.getById(danhMucSanPhamBac1.getId());
//		danhMucSanPhamBac1.setListDanhMucSanPhamBac2(danhBac1.getListDanhMucSanPhamBac2());
//		Map<String, Object> jsonResult = new HashMap<String, Object>();
//		for(DanhMucSanPhamBac2 d2 : danhMucSanPhamBac1.getListDanhMucSanPhamBac2()) {
//			System.out.println(d2.getTenDanhMuc());
//		}
//	
//		jsonResult.put("danhMucSanPhamBac2", danhBac1);
//		
//		return ResponseEntity.ok(danhMucSanPhamBac1);
//	}
	
	@RequestMapping(value = "/admin/update-status", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> updateProductStatus(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody SanPham sanPham
	){
		sanPhamService.stopSellProduct(sanPham.getId());
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("message", "Cập nhật thành công!");
		return ResponseEntity.ok(jsonResult);
	}
	
	
	@RequestMapping(value = {"/admin/xoa-san-pham"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> xoaSanPham(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody SanPham sanPham){
		
		sanPhamService.deleteSanPham(sanPham);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("message", "Xóa thành công!");
		return ResponseEntity.ok(jsonResult);
	}

}
