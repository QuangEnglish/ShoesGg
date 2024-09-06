package com.devpro.JavaWeb.services.impl;

import org.springframework.stereotype.Service;

import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.services.BaseService;

@Service
public class KhachHangService extends BaseService<KhachHang> {

	@Override
	protected Class<KhachHang> clazz() {
		// TODO Auto-generated method stub
		return KhachHang.class;
	}

}
