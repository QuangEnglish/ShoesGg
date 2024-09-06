package com.devpro.JavaWeb.services.utils;

import org.springframework.util.StringUtils;

public class Utils {
	
	public static String convertStatus(Integer status) {
		if(status == null) return "";
		switch (status) {
		case 1:
			return "Chờ duyệt đơn hàng";
		case 2:
			return "Chờ giao hàng";
		case 3:
			return "Đang giao hàng";
		case 4:
			return "Đang giao hàng lần 2";
		case 5:
			return "Giao hàng thành công";
		case -1:
			return "Hủy đơn hàng";
		case -2:
			return "Giao hàng thất bại";
		default:
			return "";
		}
	}
	
	public interface PaymentMethodType {
		int NOT_PAY = 1;
		int PAY = 2;
		int REFUNDED = 3;
		int CANCELED = 4;
	}

}
