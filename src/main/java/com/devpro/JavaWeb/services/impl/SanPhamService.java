package com.devpro.JavaWeb.services.impl;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.JavaWeb.dto.SanPhamSearch;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.services.BaseService;
import com.devpro.JavaWeb.services.PagerData;

@Service
public class SanPhamService extends BaseService<SanPham>{

	@Override
	protected Class<SanPham> clazz() {
		// TODO Auto-generated method stub
		return SanPham.class;
	}
	
	private boolean isEmptyUploadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}
	
	@Transactional
	public SanPham themSanPham(SanPham sanPham, MultipartFile multipartFile) throws IllegalStateException, IOException {
		String fileName = multipartFile.getOriginalFilename();
		
		String path = "D:\\Road_BE\\Project\\spring\\WebBanGiayMVC\\ProjectJavaWeb24_pust1\\src\\main\\resources\\image\\" + fileName;
		
		multipartFile.transferTo(new File(path));
		
		sanPham.setHinhAnh(fileName);
		
		SanPham sanPhamSave = super.saveOrUpdate(sanPham);
		return sanPhamSave;
		
	}
	
	
	public List<SanPham> searchProduct(SanPhamSearch searchModel) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM san_pham sp WHERE 1=1 and sp.status != 0";

		if (searchModel != null) {
			
			// tìm kiếm theo category
			if(searchModel.getDanhMucId() != null && !"0".equals(searchModel.getDanhMucId())) {
				sql += " and sp.id_dm_sp = " + searchModel.getDanhMucId();
			}
		

			// tìm kiếm theo title và description
			if (!StringUtils.isEmpty(searchModel.getKeyword())) {
				sql += " and (sp.ten_sp like '%" + searchModel.getKeyword() + "%')";
//						     " or p.detail_description like '%" + searchModel.getKeyword() + "%'" + 
//						     " or p.short_description like '%" + searchModel.getKeyword() + "%')";
			}
			
			// tìm kiếm theo seo
//			if(!StringUtils.isEmpty(searchModel.getSeo())) {
//				sql += " and seo = '" + searchModel.getSeo() + "'";
//			}
		}
		
		
		return getEntitiesByNativeSQL(sql);
	}
	
	public PagerData<SanPham> searchSanPham(SanPhamSearch sanPhamSearch, boolean isAdmin){
		String dieuKien = "";
		//String sql = "select * from( select *, row_number() over (order by id desc) as r from san_pham where 1 = 1" + dieuKien + ") as tam where r between "+ (so*6-5) +" and " + (so * 6);

		if(isAdmin) {
			dieuKien += " and status != 0";
		} else {
			dieuKien += " and status = 1";
		}
		
		if (sanPhamSearch != null) {
			
			// tìm kiếm theo category
			if(sanPhamSearch.getDanhMucId() != null && !"0".equals(sanPhamSearch.getDanhMucId())) {
				dieuKien += " and id_dm_sp = " + sanPhamSearch.getDanhMucId();
			}
			
			if(sanPhamSearch.getStatusSearch() != null && sanPhamSearch.getStatusSearch() != 0) {
				dieuKien += " and status = " + sanPhamSearch.getStatusSearch();
			}
	
			// tìm kiếm theo title và description
			if (!StringUtils.isEmpty(sanPhamSearch.getKeyword())) {
				dieuKien += " and (ten_sp like '%" + sanPhamSearch.getKeyword() + "%')";
//						     " or p.detail_description like '%" + searchModel.getKeyword() + "%'" + 
//						     " or p.short_description like '%" + searchModel.getKeyword() + "%')";
			}
			
			// tìm kiếm theo seo
//			if(!StringUtils.isEmpty(searchModel.getSeo())) {
//				sql += " and seo = '" + searchModel.getSeo() + "'";
//			}
			
			if(!StringUtils.isEmpty(sanPhamSearch.getStatus())) {
				
				dieuKien += " and status = " + sanPhamSearch.getStatus();
			}
			
			if(!StringUtils.isEmpty(sanPhamSearch.getTenSp())) {
				dieuKien += " and ten_sp like %" + sanPhamSearch.getTenSp() + "%";
			}
			
			if(sanPhamSearch.getMinPrice() != null) {
				dieuKien += " and gia >= " + sanPhamSearch.getMinPrice();
			}
			
			if(sanPhamSearch.getMinPrice() != null) {
				dieuKien += " and gia <= " + sanPhamSearch.getMaxPrice();
			}
			
			if(StringUtils.hasLength(sanPhamSearch.getPhienBan())) {
				dieuKien += " and thiet_ke like %" + sanPhamSearch.getPhienBan() + "%";
			}
			
		}
		String sql = "select * from( select *, row_number() over (order by id desc) as r from san_pham where id_dm_pk is null" + dieuKien + ") as tam";
		super.setSizeOfPage(sanPhamSearch.getSizeOfPage());
		return getEntitiesByNativeSQL(sql, sanPhamSearch.getPage());
	}
	
	public List<SanPham> searchProductPhanTrang(SanPhamSearch searchModel, int so) {
		// khởi tạo câu lệnh
		String dieuKien = "";
		//String sql = "select * from( select *, row_number() over (order by id desc) as r from san_pham where 1 = 1" + dieuKien + ") as tam where r between "+ (so*6-5) +" and " + (so * 6);

		if (searchModel != null) {
			
			// tìm kiếm theo category
			if(searchModel.getDanhMucId() != null && !"0".equals(searchModel.getDanhMucId())) {
				dieuKien += " and id_dm_sp = " + searchModel.getDanhMucId();
			}
		

			// tìm kiếm theo title và description
			if (!StringUtils.isEmpty(searchModel.getKeyword())) {
				dieuKien += " and (ten_sp like '%" + searchModel.getKeyword() + "%')";
//						     " or p.detail_description like '%" + searchModel.getKeyword() + "%'" + 
//						     " or p.short_description like '%" + searchModel.getKeyword() + "%')";
			}
			
			// tìm kiếm theo seo
//			if(!StringUtils.isEmpty(searchModel.getSeo())) {
//				sql += " and seo = '" + searchModel.getSeo() + "'";
//			}
		}
		String sql = "select * from( select *, row_number() over (order by id desc) as r from san_pham where id_dm_pk is null" + dieuKien + ") as tam where r between "+ (so*6-5) +" and " + (so * 6);
		
		return getEntitiesByNativeSQL(sql);
	}
	
	
	public PagerData<SanPham> searchPhuKien(SanPhamSearch searchPhuKien){
		String dieuKien = "";
		if(searchPhuKien != null) {
			if(searchPhuKien.getDanhMucId() != null && !"0".equals(searchPhuKien.getDanhMucId())) {
				dieuKien += " and id_dm_pk = " + searchPhuKien.getDanhMucId();
			}
			if(!StringUtils.isEmpty(searchPhuKien.getKeyword())) {
				dieuKien += " and (ten_sp like '%" + searchPhuKien.getKeyword() + "%')";
			}
			if(!StringUtils.isEmpty(searchPhuKien.getStatus())) {
				dieuKien += " and status = " + searchPhuKien.getStatus();
			}
		}
		String sql = "select * from( select *, row_number() over (order by id desc) as r from san_pham where id_dm_sp is null" + dieuKien + ") as tam";
		
		super.setSizeOfPage(searchPhuKien.getSizeOfPage());
		return getEntitiesByNativeSQL(sql, searchPhuKien.getPage());
	}
	
	public PagerData<SanPham> timKiemTatCaSanPham(SanPhamSearch sanPhamSearch){
		String sql = "select * from( select *, row_number() over (order by id desc) as r from san_pham where ten_sp like '%" + sanPhamSearch.getKeyword() + "%') as tam";
		super.setSizeOfPage(sanPhamSearch.getSizeOfPage());
		return getEntitiesByNativeSQL(sql, sanPhamSearch.getPage());

	}
	
	
	@Transactional
	public SanPham updateSanPham(SanPham sanPham, MultipartFile multipartFile) throws IllegalStateException, IOException {
		SanPham sanPhaninDB = super.getById(sanPham.getId());
		if(!isEmptyUploadFile(multipartFile)) {
			new File("D:\\Road_BE\\Project\\spring\\WebBanGiayMVC\\ProjectJavaWeb24_pust1\\src\\main\\resources\\image\\" + sanPhaninDB.getHinhAnh()).delete();
			
			multipartFile.transferTo(new File("D:\\Road_BE\\Project\\spring\\WebBanGiayMVC\\ProjectJavaWeb24_pust1\\src\\main\\resources\\image\\" + multipartFile.getOriginalFilename()));
			sanPham.setHinhAnh(multipartFile.getOriginalFilename());
		} else {
			sanPham.setHinhAnh(sanPhaninDB.getHinhAnh());
		}
		
		return super.saveOrUpdate(sanPham);
	}
	
	@Transactional 
	public SanPham deleteSanPham(SanPham sanPham) {
		SanPham sanPhamXoa = super.getById(sanPham.getId());
		if(sanPhamXoa.getStatus() == 0) {
			return sanPhamXoa;
		}
		sanPhamXoa.setStatus(0);
		return super.saveOrUpdate(sanPhamXoa);
	}
	
	
	@Transactional
	public SanPham stopSellProduct(Integer id) {
		SanPham sanPhamStopCell = super.getById(id);
		if(sanPhamStopCell.getStatus() == -1) {
			sanPhamStopCell.setStatus(1);
		} else {
			sanPhamStopCell.setStatus(-1);
		}
		return super.saveOrUpdate(sanPhamStopCell);
	}
	

}
