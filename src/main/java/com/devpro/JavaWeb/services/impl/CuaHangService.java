package com.devpro.JavaWeb.services.impl;


import org.springframework.stereotype.Service;

import com.devpro.JavaWeb.model.CuaHang;
import com.devpro.JavaWeb.services.BaseService;

@Service
public class CuaHangService extends BaseService<CuaHang> {

	@Override
	protected Class<CuaHang> clazz() {
		// TODO Auto-generated method stub
		return CuaHang.class;
	}

	

}
