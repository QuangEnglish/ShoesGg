package com.devpro.JavaWeb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpro.JavaWeb.model.BinhLuan;
import com.devpro.JavaWeb.model.BoSuuTap;
import com.devpro.JavaWeb.services.BaseService;


@Service
public class BinhLuanService extends BaseService<BinhLuan> {
	
	@Override
	protected Class<BinhLuan> clazz() {
		// TODO Auto-generated method stub
		return BinhLuan.class;
	}
	
	public List<BinhLuan> getListBinhLuanBySanPham(Integer idSanPham) {
		String sql = "select * from binh_luan b where b.id_san_pham = " + idSanPham + " order by b.created_at desc";
		return getEntitiesByNativeSQL(sql);
	}

}
