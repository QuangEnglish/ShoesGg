package com.devpro.JavaWeb.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.text.DecimalFormat;

/**
 * biểu thị cho giỏ hàng
 * @author daing
 *
 */
public class Cart {

	// tổng số tiền trong giỏ hàng
	private BigDecimal totalPrice = BigDecimal.ZERO;
	
	// tổng số lượng sản phẩm trong giỏ hàng
	private Integer totalProducts = 0;
	
	// danh sách sản phẩm trong giỏ hàng
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}
	
	public String getTongTienFM() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(this.totalPrice);
	}
}
