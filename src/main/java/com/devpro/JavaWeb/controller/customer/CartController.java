package com.devpro.JavaWeb.controller.customer;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.devpro.JavaWeb.controller.BaseController;
import com.devpro.JavaWeb.dto.Cart;
import com.devpro.JavaWeb.dto.CartItem;
import com.devpro.JavaWeb.model.ChiTietHoaDon;
import com.devpro.JavaWeb.model.HoaDon;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.model.SanPham;
import com.devpro.JavaWeb.services.impl.ChiTietHoaDonService;
import com.devpro.JavaWeb.services.impl.HoaDonService;
import com.devpro.JavaWeb.services.impl.KhachHangService;
import com.devpro.JavaWeb.services.impl.SanPhamService;
import com.devpro.JavaWeb.services.utils.Utils;

@Controller
public class CartController extends BaseController{
	
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	
	@RequestMapping(value =  {"/gio-hang"}, method = RequestMethod.GET)
	public String gioHangGet(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
	throws IOException {
		//System.out.println(getUserLogined().getIdKhachHang());
		return "customer/giohang";
	}

	@RequestMapping(value = {"/ajax/addToCart"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> themSPGioHang(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CartItem cartItem)
	throws IOException {
		HttpSession session = request.getSession();
		
		Cart cart = new Cart();
		
		// kiểm tra xem session có tồn tại đối tượng nào tên là "cart"
				if (session.getAttribute("cart") != null) { // tồn tại 1 giỏ hàng trên session
					cart = (Cart) session.getAttribute("cart");
				} else {// chưa có giỏ hàng nào trên session
					cart = new Cart(); //khởi tạo giỏ hàng mới
					session.setAttribute("cart", cart);
				}

				// Lấy danh sách sản phẩm đang có trong giỏ hàng
				List<CartItem> cartItems = cart.getCartItems();

				// kiểm tra nếu sản phẩm muốn bổ sùng vào giỏ hàng có trong giỏ hàng nếu có thì tăng số lượng
				boolean isExists = false;
				for (CartItem item : cartItems) {
					if (item.getProductId() == cartItem.getProductId() && item.getSize().equals(cartItem.getSize())) {
						isExists = true;
						// tăng số lượng sản phẩm lên
						item.setQuanlity(item.getQuanlity() + cartItem.getQuanlity());
					}
				}

				// nếu sản phẩm chưa có trong giỏ hàng thì thực hiện add sản phẩm đó vào giỏ hàng
				if (!isExists) {
					// trước khi thêm mới thì lấy sản phẩm trong db
					// và thiết lập tên + đơn giá cho cartitem
					SanPham sanPhamId = sanPhamService.getById(cartItem.getProductId());

					cartItem.setProductName(sanPhamId.getTenSanPham());
					cartItem.setPriceUnit(sanPhamId.getGia());
					cartItem.setHinhAnh(sanPhamId.getHinhAnh());
					cartItem.setMauSac(sanPhamId.getMauSac());
					cart.getCartItems().add(cartItem); // thêm mới sản phẩm vào giỏ hàng
				}

				
				// tính tổng tiền
				cart.setTotalPrice(getTotalPrice(request));
//				this.calculateTotalPrice(request);
				cart.setTotalProducts(getTotalItems(request));
				// trả về kết quả
				Map<String, Object> jsonResult = new HashMap<String, Object>();
				jsonResult.put("status", "success");
				jsonResult.put("totalItems", getTotalItems(request));
				
				// lưu totalItems vào session
				// tất cả các giá trị lưu trên session đều có thể truy cập được từ View
//				session.setAttribute("TongSoLuongSanPhamTrongGioHang", getTotalItems(request));
				
				return ResponseEntity.ok(jsonResult);

	}
	
	@RequestMapping(value = {"/ajax/tangGiamSanPham"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> TangGiamSPGioHang(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CartItem cartItem)
	throws IOException {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		//session.setAttribute("cart", null);
		//session.setAttribute("cart", cart);
		for(CartItem cartIt : cart.getCartItems()) {
			if(cartIt.getProductId() == cartItem.getProductId() && cartIt.getSize().equals(cartItem.getSize())) {
				cartIt.setQuanlity(cartItem.getQuanlity());
			}
		}
		cart.setTotalPrice(this.getTotalPrice(request));
		cart.setTotalProducts(this.getTotalItems(request));
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		return ResponseEntity.ok(jsonResult);
		
	}
	
	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("tongsosanphamgiohang", 0);
		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}

		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuanlity();
		}
		httpSession.setAttribute("tongsosanphamgiohang", total);

		return total;
	}
	
	
	@RequestMapping(value = {"/ajax/xoaSanPhamGH"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> xoaSanPhamGH(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CartItem cartItem){
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		for(CartItem cItem : cart.getCartItems()) {
			if(cartItem.getProductId() == cItem.getProductId()) {
				cart.getCartItems().remove(cItem);
				break;
			}
		}
		cart.setTotalPrice(this.getTotalPrice(request));
		cart.setTotalProducts(this.getTotalItems(request));
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("message", "Xóa thành công!");
		return ResponseEntity.ok(jsonResult);
	}
	
	private BigDecimal getTotalPrice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("cart") == null) {
			return new BigDecimal("0");
		}

		Cart cart = (Cart) session.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		BigDecimal total = new BigDecimal("0");
		for (CartItem item : cartItems) {
			
			BigDecimal a = new BigDecimal(item.getPriceUnit() + "").multiply(BigDecimal.valueOf(item.getQuanlity()));
			total = total.add(a);
		}
		
		return total;
	}
	
	@RequestMapping(value = {"/thanh-toan"}, method = RequestMethod.GET)
	public String thanhToan(final Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		Boolean isPayment = false;
		if(!StringUtils.isEmpty(request.getParameter("ispayment"))) {
			isPayment = true;
		}
		model.addAttribute("payment", isPayment);
		return "customer/thanhtoan";
	}
	
	@RequestMapping(value = {"/thanh-toan"}, method = RequestMethod.POST)
	public String thanhToanPOST(final Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
	
		String hoTen = request.getParameter("hoten");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		String diaChiNhan = request.getParameter("diachinhan");
		Integer loaiThanhToan = Integer.parseInt(request.getParameter("loaiThanhToan"));
		
		KhachHang khachHang = new KhachHang();
		if(isLogined()) {
			khachHang.setIdTaiKhoan(getUserLogined().getId());
		}
		khachHang.setHoTen(hoTen);
		khachHang.setSoDienThoai(sdt);
		khachHang.setEmail(email);
		khachHang.setDiaChi(diaChiNhan);
		
		HttpSession session = request.getSession();
		session.setAttribute("khachHang", khachHang);
		session.setAttribute("loaiThanhToan", loaiThanhToan);
		
		Cart cart = (Cart) session.getAttribute("cart");
		if(loaiThanhToan != null && loaiThanhToan == 1) {
			return "redirect:/pay?giaTien=" + cart.getTotalPrice();
		} else {
			savePayment(khachHang, request);
		}
		return "redirect:/thanh-toan?ispayment=true";
	}
	
	
	public void savePayment(
			KhachHang khachHang,
			HttpServletRequest request
		) {
		KhachHang khachHangUpdate = khachHangService.saveOrUpdate(khachHang);
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		HoaDon hoaDon = new HoaDon();
		hoaDon.setKhachHang(khachHangUpdate);
		hoaDon.setCreatedDate(new Date());
		hoaDon.setTongSoLuong(cart.getTotalProducts());
		hoaDon.setThanhTien(cart.getTotalPrice());
		hoaDon.setPaymentMethod((Integer) session.getAttribute("loaiThanhToan"));
		if(hoaDon.getPaymentMethod() == 1) {
			hoaDon.setPaymentStatus(Utils.PaymentMethodType.PAY);
		} else if(hoaDon.getPaymentMethod() == 2){
			hoaDon.setPaymentStatus(Utils.PaymentMethodType.NOT_PAY);
		}
		hoaDon.setStatus(1);
		HoaDon hoaDonUpdate = hoaDonService.saveOrUpdate(hoaDon);
		
		for(CartItem cartItem : cart.getCartItems()) {
			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
			SanPham sanPham = sanPhamService.getById(cartItem.getProductId());
			chiTietHoaDon.setHoaDon(hoaDonUpdate);
			chiTietHoaDon.setSanPham(sanPham);
			chiTietHoaDon.setSize(cartItem.getSize());
			chiTietHoaDon.setSoLuong(cartItem.getQuanlity());
			chiTietHoaDonService.saveOrUpdate(chiTietHoaDon);
		}
		session.setAttribute("cart", null);
		session.setAttribute("tongsosanphamgiohang", "");
	}
	
	

}
