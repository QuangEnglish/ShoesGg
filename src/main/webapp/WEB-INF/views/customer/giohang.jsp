<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <link rel="stylesheet" href="${base }/css/giohang1.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <title>Document</title>
</head>
<body>
    <header>
        <div class="logo" onclick="TroVeTrangChu()">
            <img src="${base }/image/logoOff.png" alt="">
        </div>
    </header>
    <div id="body-content">
        <div class="tieude">
            <p style="text-align: center; font-size: 30px; font-weight: bold;">Giỏ Hàng</p>
        </div>
        <div class="giohang">
            <div class="giohang-left">
                <h2>Giỏ hàng của bạn (${cart.totalProducts })</h2>

                <c:forEach items="${cart.cartItems }" var="ci">

                	<div class="dongsanpham">
                    <div class="anhsanpham">
                        <img src="${base }/image/${ci.hinhAnh}" alt="">
                    </div>
                    <div class="thongtin">
                        <p class="tenao">${ci.productName }</p>
                        <p class="mau-size">${ci.mauSac}/${ci.size }</p>
                        <table>
                            <tr>
                                <td onclick="Giam('${base}', ${ci.productId }, '${ci.productId }' + '${ci.size }', '${ci.size }')" class="tang">-</td>
                                <td id="${ci.productId}${ci.size }">${ci.quanlity }</td>
                                <td onclick="Tang('${base}', ${ci.productId }, '${ci.productId }${ci.size }', '${ci.size }')" class="tang">+</td>
                            </tr>
                        </table>
                        <div class="xoa" onclick="XoaSanPham('${base}', ${ci.productId })">
                            <a >Xóa</a>
                        </div>
                    </div>
                    <div class="gia">
                        <p>${ci.getTienFM() }đ</p>
                    </div>
                    <div class="yeuthich">
                        <i class="ti-heart"></i>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>

                </c:forEach>

                </div>

            <div class="giohang-right">
                <div class="tamtinh">
                    <p class="tam">Tạm tính:</p>
                    <p class="giatamtinh">${cart.getTongTienFM() }</p>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
                <p class="mienphi">Miễn phí vấn chuyển cho đơn hàng từ 500k</p>
                <div class="tienhanhdat" onclick="DatHang(${cart.totalProducts })">
                    <p>TIẾN HÀNH ĐẶT HÀNG</p>
                </div>
                <p class="uudai">Ưu đãi hội viên</p>
                <p class="tichdiem">Tích điểm đổi quà và rất nhiều ưu đãi đặc biệt khác, chỉ dành cho hội viên của Aristino.</p>
                <p class="dnhap">Đăng nhập</p>
            </div>
        </div>
    </div>
    <div class="clear"></div>

	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>

</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/cart.js"></script>

<script>
	function TroVeTrangChu() {
		window.location = '/trang-chu';
	}

	function  DatHang(tong) {
		if(tong > 0){
			window.location = "/thanh-toan";
		} else {
			alert("Bạn cần phải thêm ít nhất 1 sản phẩm vào giỏ hàng");
		}

	}
</script>

</html>

