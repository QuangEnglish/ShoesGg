package com.devpro.JavaWeb.services.impl;

import org.springframework.stereotype.Service;

import com.devpro.JavaWeb.model.ChiTietHoaDon;
import com.devpro.JavaWeb.services.BaseService;

@Service
public class ChiTietHoaDonService extends BaseService<ChiTietHoaDon> {

	@Override
	protected Class<ChiTietHoaDon> clazz() {
		// TODO Auto-generated method stub
		return ChiTietHoaDon.class;
	}

}
