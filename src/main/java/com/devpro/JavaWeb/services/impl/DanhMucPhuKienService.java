package com.devpro.JavaWeb.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.JavaWeb.dto.DanhMucSearch;
import com.devpro.JavaWeb.model.DanhMucPhuKien;
import com.devpro.JavaWeb.services.BaseService;
import com.devpro.JavaWeb.services.PagerData;


@Service
public class DanhMucPhuKienService extends BaseService<DanhMucPhuKien>{

	@Override
	protected Class<DanhMucPhuKien> clazz() {
		// TODO Auto-generated method stub
		return DanhMucPhuKien.class;
	}
	
	public PagerData<DanhMucPhuKien> SearchPhuKien(DanhMucSearch danhMucSearch) {
		String dieuKien = "";
		if(!StringUtils.isEmpty(danhMucSearch.getTenDanhMuc())) {
			dieuKien += " and ten_dm like '" + danhMucSearch.getTenDanhMuc() + "'";
		}
		
		super.setSizeOfPage(danhMucSearch.getSizeOfPage());
		String sql = "select * from danh_muc_phu_kien where 1 = 1" + dieuKien + " order by id desc";
		return getEntitiesByNativeSQL(sql, danhMucSearch.getPage());
	}

}
