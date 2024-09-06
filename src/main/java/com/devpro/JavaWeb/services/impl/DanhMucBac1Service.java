package com.devpro.JavaWeb.services.impl;

import org.springframework.stereotype.Service;

import com.devpro.JavaWeb.model.DanhMucSanPhamBac1;
import com.devpro.JavaWeb.services.BaseService;

@Service
public class DanhMucBac1Service extends BaseService<DanhMucSanPhamBac1>{

	@Override
	protected Class<DanhMucSanPhamBac1> clazz() {
		// TODO Auto-generated method stub
		return DanhMucSanPhamBac1.class;
	}

}
