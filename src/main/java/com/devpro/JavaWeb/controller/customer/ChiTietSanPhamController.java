package com.devpro.JavaWeb.controller.customer;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.BinhLuanDTO;
import com.devpro.JavaWeb.model.BinhLuan;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.model.TaiKhoan;
import com.devpro.JavaWeb.services.impl.BinhLuanService;
import com.devpro.JavaWeb.services.impl.SanPhamService;

import net.bytebuddy.implementation.bind.annotation.Super;

@Controller
public class ChiTietSanPhamController extends BaseController {
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	BinhLuanService binhLuanService;

	@RequestMapping(value = {"/chi-tiet-san-pham"}, method = RequestMethod.GET)
	public String chiTietSP(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		Integer idSanPham = Integer.parseInt(request.getParameter("id"));
		SanPham sanPham = sanPhamService.getById(idSanPham);
		model.addAttribute("sanPham",sanPham);
		String[] size = sanPham.getSize().split("/");
		
		model.addAttribute("size", size);
		
		Integer idDanhMuc = 0;
		if(sanPham.getDanhMucPhuKien() != null) {
			idDanhMuc = sanPham.getDanhMucPhuKien().getId();
		} else {
			idDanhMuc = sanPham.getDanhMucSanPhamBac2().getId();
		}
		
		List<SanPham> sanPhamLienQuan = new ArrayList<SanPham>();
		sanPhamLienQuan = sanPhamService.getEntitiesByNativeSQL("select * from (select *, row_number() over (order by id desc) as r from san_pham where id != "+ sanPham.getId() +" and (id_dm_sp = " + idDanhMuc + " or id_dm_pk = "+ idDanhMuc +")) as tam where r between 1 and 12");
		model.addAttribute("sanPhamLienQuan" ,sanPhamLienQuan);
		model.addAttribute("isLogined", super.isLogined());
		List<BinhLuan> binhLuans = binhLuanService.getListBinhLuanBySanPham(idSanPham);
		List<BinhLuanDTO> binhLuanDTOs = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());
		for(BinhLuan binhLuan : binhLuans) {
			BinhLuanDTO binhLuanDTO = new BinhLuanDTO();
			binhLuanDTO.setId(binhLuan.getId());
			binhLuanDTO.setContent(binhLuan.getContent());
			binhLuanDTO.setRating(binhLuan.getRating());
			binhLuanDTO.setUserName(binhLuan.getUserCreate());
			binhLuanDTO.setCreatedAt(formatter.format(binhLuan.getCreatedAt()));
			binhLuanDTOs.add(binhLuanDTO);
		}
		model.addAttribute("binhLuans", binhLuanDTOs);
		return "customer/chitietsanpham";
	}
	
	@RequestMapping(value = "/gui-binh-luan", method = RequestMethod.POST)
	public String guiBinhLuan(
			final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response
			) {
		TaiKhoan taiKhoan = super.getUserLogined();
		Integer idSanPham = Integer.parseInt(request.getParameter("idSanPham"));
		String content = request.getParameter("content");
		int rate = 0;
		if(!StringUtils.isEmpty(request.getParameter("rating"))){
			rate = Integer.parseInt(request.getParameter("rating"));
		}
		BinhLuan binhLuan = new BinhLuan();
		binhLuan.setCreatedBy(taiKhoan.getId());
		binhLuan.setContent(content);
		binhLuan.setCreatedAt(Instant.now());
		binhLuan.setRating(rate);
		binhLuan.setIdSanPham(idSanPham);
		binhLuanService.saveOrUpdate(binhLuan);
		return "redirect:/chi-tiet-san-pham?id=" + idSanPham;
	}
	
	
}
