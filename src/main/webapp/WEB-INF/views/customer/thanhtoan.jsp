<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <link rel="stylesheet" href="${base }/css/thanhtoan.css">
    <title>Document</title>
</head>
<body>
<header>
    <div class="logo" onclick="TroVeTrangChu()">
        <img src="${base }/image/logoOff.png" alt="">
    </div>
</header>
<div id="thanhtoan">
    <c:choose>
        <c:when test="${isLogined }">
                <form action="${base }/thanh-toan" method="post" style="display: flex;justify-content: center;">
                    <div class="thongtinkhachhang">
                        <p class="tieude">GIAO HÀNG VÀ THANH TOÁN</p>
                        <p>Họ tên: <br> <input type="text" name="hoten" value="${khachHang.hoTen }" required></p>
                        <p>Số điện thoại: <br> <input type="text" name="sdt" value="${khachHang.soDienThoai }" id="numberPhoneId"
                                                      required></p>
                        <p>Email nhận thông tin đơn hàng: <br> <input type="text" name="email" value="${khachHang.email }"
                                                                      id="emailId" required></p>
                        <p>Địa chỉ nhận hàng: <br> <input type="text" name="diachinhan" value="${khachHang.diaChi }"
                                                          required></p>
                        <p>Hình thức thanh toán:</p>
                            <input style="width: 15px;height: 15px;" type="radio" value="1" name="loaiThanhToan">Thanh toán qua Paypal
                            <input style="width: 15px;height: 15px;" type="radio" value="2" name="loaiThanhToan">Thanh toán khi nhận hàng
                        <p><input type="submit" value="XÁC NHẬN ĐẶT HÀNG" class="nut xacnhan"></p>
                        <p><input type="button" value="HỦY" class="nut" onclick="HuyDatHang()"></p>
                    </div>
                </form>
        </c:when>
        <c:otherwise>
            <form action="${base }/thanh-toan" method="post" style="display: flex;justify-content: center;">
                <div class="thongtinkhachhang">
                    <p class="tieude">GIAO HÀNG VÀ THANH TOÁN</p>
                    <p>Họ tên: <br> <input type="text" name="hoten" required></p>
                    <p>Số điện thoại: <br> <input type="text" name="sdt" id="" required></p>
                    <p>Email nhận thông tin đơn hàng: <br> <input type="text" name="email" id="" required></p>
                    <p>Địa chỉ nhận hàng: <br> <input type="text" name="diachinhan" required></p>
                    <p>Hình thức thanh toán: </br>
                        <input type="radio" value="1" name="loaiThanhToan" class="payment-method">Thanh toán qua
                        Paypal </br>
                        <input type="radio" value="2" name="loaiThanhToan" class="payment-method">Thanh toán khi nhận
                        hàng
                    </p>
                    <p><input type="submit" value="XÁC NHẬN ĐẶT HÀNG" class="nut xacnhan"></p>
                    <p><input type="button" value="HỦY" class="nut" onclick="HuyDatHang()"></p>
                </div>
            </form>
        </c:otherwise>
    </c:choose>


    <div class="thongtindonhang">
        <p class="donhang">Đơn Hàng(${cart.totalProducts })</p>
        <div class="danhsachsanpham">
            <c:forEach items="${cart.cartItems }" var="ci">
                <div class="sanpham">
                    <img src="${base }/image/${ci.hinhAnh}" alt="">
                    <div class="thongtinsanpham">
                        <p class="tensanpham">${ci.productName }</p>
                        <p class="mausac">Màu: ${ci.mauSac }</p>
                        <p class="mausac">Size: ${ci.size }</p>
                        <p class="mausac">Số lượng: ${ci.quanlity }</p>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div class="clear"></div>
        <div class="tinhtien">
            <p class="tamtinh">Tạm tính: <strong>${cart.getTongTienFM() }</strong></p>
            <p class="vanchuyen">Vận chuyển: <strong>0đ</strong></p>
            <p class="thanhtien">Thành tiền: <strong>${cart.getTongTienFM() }</strong></p>
        </div>
    </div>
</div>
<div class="clear"></div>

<c:if test="${payment }">
	<div class="overlay"></div>
	
	<!-- Mockup thông báo -->
	<div class="modal" >
	    <img src="./image/tichXanhThanhCong.png" alt="Dấu tích xanh" class="icon">
	    <h2>Thanh Toán Thành Công!</h2>
	    <p style="margin-top: 10px;">ĐƠN HÀNG CỦA BẠN ĐÃ THANH TOÁN THÀNH CÔNG</p>
	    <p style="font-size: 12px; color: #8a8787;">Nhân viên của chúng tôi sẽ liên hệ thông báo giao hàng với bạn</p>
	    <a href="${base}/trang-chu" class="button">Quay lại trang chủ</a>
	</div>

</c:if>
<!-- Nền bóng mờ -->

</body>

<script type="text/javascript">
    function HuyDatHang() {
        window.location = "/gio-hang";
    }
    
</script>
</html>