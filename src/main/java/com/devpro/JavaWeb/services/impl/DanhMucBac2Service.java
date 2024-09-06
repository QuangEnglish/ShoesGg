package com.devpro.JavaWeb.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.JavaWeb.dto.DanhMucSearch;
import com.devpro.JavaWeb.model.DanhMucSanPhamBac2;
import com.devpro.JavaWeb.services.BaseService;
import com.devpro.JavaWeb.services.PagerData;

@Service
public class DanhMucBac2Service extends BaseService<DanhMucSanPhamBac2>{

	@Override
	protected Class<DanhMucSanPhamBac2> clazz() {
		// TODO Auto-generated method stub
		return DanhMucSanPhamBac2.class;
	}
	
	
	public PagerData<DanhMucSanPhamBac2> searchDanhMucBac2(DanhMucSearch danhMucSearch) {
		String dieuKien = "";
		if(!StringUtils.isEmpty(danhMucSearch.getTenDanhMuc())) {
			dieuKien = " and ten_dm like '%" + danhMucSearch.getTenDanhMuc() + "%'";
		}
		super.setSizeOfPage(danhMucSearch.getSizeOfPage());
		String sql = "select * from danh_muc_san_pham_bac2 where 1 = 1 and status != 0" + dieuKien + " order by id desc";
		return getEntitiesByNativeSQL(sql, danhMucSearch.getPage());
	}
	
	
	
}
