package com.devpro.JavaWeb.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.JavaWeb.dto.TaiKhoanSearch;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.model.TaiKhoan;
import com.devpro.JavaWeb.services.BaseService;
import com.devpro.JavaWeb.services.PagerData;

@Service
public class UserDetailsServiceImpl extends BaseService<TaiKhoan> implements UserDetailsService {

	@Autowired
	KhachHangService khachHangService;
	 
	@Override
	protected Class<TaiKhoan> clazz() {
		return TaiKhoan.class;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// connect tới db và lấy user theo username
		String sql = "select * from tai_khoan u where u.username = '" + username + "' and stastus = 1";
		TaiKhoan user = this.getEntityByNativeSQL(sql);
		
		return user;
	}

	public PagerData<TaiKhoan> searchTaiKhoan(TaiKhoanSearch taiKhoanSearch){
		String dieuKien = "";
		if(taiKhoanSearch != null) {
			if(!StringUtils.isEmpty(taiKhoanSearch.getTenKhachHang())) {
				
				List<KhachHang> list = new ArrayList<KhachHang>();
				list = khachHangService.getEntitiesByNativeSQL("SELECT * FROM khach_hang WHERE ho_ten like '%" + taiKhoanSearch.getTenKhachHang() + "%'");
				
				if(list.size() > 0) {
					dieuKien += "and id_kh in (";
					for(int i = 0; i < list.size()-1; i++) {
						dieuKien += list.get(i).getId() + ",";
					}
					dieuKien += list.get(list.size() -1).getId() + ")";
				}
			}
		}
		
		String sql = "SELECT * FROM tai_khoan WHERE 1 = 1 and id_kh is not null " + dieuKien;
		super.setSizeOfPage(taiKhoanSearch.getSizeOfPage());
		return getEntitiesByNativeSQL(sql, taiKhoanSearch.getPage());
	}
	
	
	@Transactional
	public TaiKhoan xoaTaiKhoan(TaiKhoan t) {
		return saveOrUpdate(t);
	}
	

}
