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
import com.devpro.JavaWeb.model.BoSuuTap;
import com.devpro.JavaWeb.services.impl.BoSuuTapService;
import com.devpro.JavaWeb.services.impl.SanPhamService;

@Controller
public class BoSuuTapController extends BaseController{
	
	@Autowired
	BoSuuTapService boSuuTapService;
	
	@Autowired
	SanPhamService sanPhamService;

	@RequestMapping(value = {"/bo-suu-tap-xuan-he-2022"}, method = RequestMethod.GET)
	public String xuanHe2022(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException{
		
		String tenBST = request.getParameter("tenbst");
		
		String sql = "SELECT * FROM bo_suu_tap where Ten_bo_suu_tap like '%" + tenBST + "%'";
		
		BoSuuTap boSuuTap = boSuuTapService.getEntityByNativeSQL(sql);
		model.addAttribute("boSuuTap", boSuuTap);
		
		String[] moTa = boSuuTap.getNoiDung().split(",");
		
		model.addAttribute("moTa", moTa[0]);
		String laySP = "select * from san_pham where id_bo_suu_tap = " + boSuuTap.getId() + " and status = 1 order by id desc"; 
		model.addAttribute("sanPhams", sanPhamService.getEntitiesByNativeSQL(laySP));
		return "customer/bosuutapxuanhe2022";
	}
	
}
