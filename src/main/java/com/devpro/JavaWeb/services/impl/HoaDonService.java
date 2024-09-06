package com.devpro.JavaWeb.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.JavaWeb.dto.HoaDonSearch;
import com.devpro.JavaWeb.model.HoaDon;
import com.devpro.JavaWeb.services.BaseService;
import com.devpro.JavaWeb.services.PagerData;

@Service
public class HoaDonService extends BaseService<HoaDon> {

	@Override
	protected Class<HoaDon> clazz() {
		// TODO Auto-generated method stub
		return HoaDon.class;
	}
	
	public PagerData<HoaDon> searchHoaDon(HoaDonSearch hoaDonSearch){
		String dieuKien = "";
		if(!StringUtils.isEmpty(hoaDonSearch.getTenKhachHang())) {
			dieuKien = " and ho_ten like '%" + hoaDonSearch.getTenKhachHang() + "%'";
		}
		
		if(!StringUtils.isEmpty(hoaDonSearch.getIdTaiKhoan())) {
			dieuKien += " and id_tai_khoan = " + hoaDonSearch.getIdTaiKhoan();
		}
		
		if(hoaDonSearch.getStatus() != null && hoaDonSearch.getStatus() != 0) {
			dieuKien += " and hoa_don.status = " + hoaDonSearch.getStatus();
		}
		
		if(hoaDonSearch.getPaymentMethod() != null && hoaDonSearch.getPaymentMethod() != 0) {
			dieuKien += " and payment_method = " + hoaDonSearch.getPaymentMethod();
		}
		
		if(hoaDonSearch.getPaymentStatus() != null && hoaDonSearch.getPaymentStatus() != 0) {
			dieuKien += " and payment_status = " + hoaDonSearch.getPaymentStatus();
		}
		
		String sql = "SELECT * FROM hoa_don inner join khach_hang on hoa_don.id_kh = khach_hang.id where 1=1 " + dieuKien + " order by hoa_don.id desc";
		
		super.setSizeOfPage(hoaDonSearch.getSizeOfPage());
		return this.getEntitiesByNativeSQL(sql, hoaDonSearch.getPage());
	}
	


}
