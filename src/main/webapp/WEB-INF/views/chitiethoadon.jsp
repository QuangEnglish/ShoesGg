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
    <link rel="stylesheet" href="${base }/css/chitiethoadon.css">
    <link rel="stylesheet" href="${base }/css/menu.css">
<%--    <link rel="stylesheet" href="${base }/css/header1.css">--%>
    <title>Document</title>
</head>
<body>
<c:if test="${isUser == null || isUser }">
    <jsp:include page="/WEB-INF/views/administrator/layout/menu.jsp"></jsp:include>
</c:if>
<c:if test="${isUser != null && !isUser }">
    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
</c:if>

    <div id="chi-tiet-hoa-don">
    	<c:if test="${isUser == null || isUser }">
    		<div style="float: right;">
    			<input type="button" value="Hủy đơn hàng" onclick="ChangeBillStatus('${hoaDon.id }', '-1')"></input>
    		</div>
    	</c:if>
    	<c:if test="${isUser != null && !isUser && (hoaDon.status == null || hoaDon.status == 1 || hoaDon.status == 2) }">
		    <div style="float: right;">
		    	<input type="button" value="Hủy đơn hàng" onclick="ChangeBillStatusUser('${hoaDon.id }', '-1')"></input>
		    </div>
		</c:if>
    	<div style="clear: both;"></div>
        <h1>CHI TIẾT HÓA ĐƠN</h1>
        <div class="thongtinhoadon">
            <table>
                <tr>
                    <td>Mã HĐ: HĐ00${hoaDon.id }</td>
                    <td>Ngày mua: ${hoaDon.createdDate }</td>
                </tr>
                <tr>
                    <td>Họ tên khách hàng: ${hoaDon.khachHang.hoTen }</td>
                    <td>Số điện thoại: ${hoaDon.khachHang.soDienThoai }</td>
                </tr>
                <tr>
                    <td>Địa chỉ nhận hàng: ${hoaDon.khachHang.diaChi }</td>
                    <td>Hình thức thanh toán: 
                    	<c:if test="${hoaDon.paymentMethod == null || hoaDon.paymentMethod == 2 }">ATM</c:if>
                    	<c:if test="${hoaDon.paymentMethod != null && hoaDon.paymentMethod == 1 }">COD</c:if>
                    </td>
                </tr>
                <tr>
                	<td>Trạng thái thanh toán: 
                		<c:if test="${hoaDon.paymentStatus == 1 }">Chưa thanh toán</c:if>
                		<c:if test="${hoaDon.paymentStatus == 2 }">Đã thanh toán</c:if>
                		<c:if test="${hoaDon.paymentStatus == 3 }">Đã hoàn tiền</c:if>
                		<c:if test="${hoaDon.paymentStatus == 4 }">Đã hủy bỏ</c:if>
                	</td>
                </tr>
                <tr>
                	<td colspan="2">Trạng thái: ${status }</td>
                </tr>
                <c:if test="${isUser == null || isUser }">
                	<tr>
                	<c:if test="${hoaDon.status == 1 || hoaDon.status == null }">
	                	<td>
	                		<input type="button" value="Duyệt đơn hàng" onclick="ChangeBillStatus('${hoaDon.id }', '2')"></input>
	                	</td>
                	</c:if>
                	<c:if test="${hoaDon.status == 2 }">
	                	<td>
	                		<input type="button" value="Bắt đầu giao hàng" onclick="ChangeBillStatus('${hoaDon.id }', '3')"></input>
	                	</td>
                	</c:if>
                	<c:if test="${hoaDon.status == 3 }">
                		<td><input type="button" value="Giao hàng thành công" onclick="ChangeBillStatus('${hoaDon.id }', '5')"/></td>
                		<td><input type="button" value="Giao hàng thất bại, chờ giao hàng lần 2" onclick="ChangeBillStatus('${hoaDon.id }', '4')"/></td>
                	</c:if>
                	<c:if test="${hoaDon.status == 4 }">
                		<td><input type="button" value="Giao hàng thành công" onclick="ChangeBillStatus('${hoaDon.id }', '5')"/></td>
                		<td><input type="button" value="Gia hàng thất bại" onclick="ChangeBillStatus('${hoaDon.id }', '-2')"/></td>
                	</c:if>
                	
                </tr>
                </c:if>
            </table>
        </div>
        <div class="thongtinsanpham">
            <table>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Màu sắc</th>
                    <th>Size</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Thành tiền</th>
                </tr>
                <c:forEach items="${hoaDon.chiTietHoaDons }" var="sp">
                	<tr>
                    <td>${sp.sanPham.id }</td>
                    <td>${sp.sanPham.tenSanPham }</td>
                    <td>${sp.sanPham.mauSac }</td>
                    <td>${sp.size }</td>
                    <td>${sp.soLuong }</td>
                    <td>${sp.sanPham.getEpGia() }</td>
                    <td>${sp.epThanhTien() }</td>
                	</tr>
                </c:forEach>
                
            </table>
        </div>
        <div class="tongtien">Tổng tiền: ${hoaDon.getThanhTienFM() } VNĐ</div>
    </div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="${base}/js/jquery.simplePagination.js"></script>
<script type="text/javascript">

	function ChangeBillStatus(id, status) {
		console.log("id: " + id + " status: " + status);
		window.location = "/admin/bill/chang-status?idhd=" + id + "&status=" + status;
	}
	
	function ChangeBillStatusUser(id, status) {
		console.log("id: " + id + " status: " + status);
		window.location = "/bill/chang-status?idhd=" + id + "&status=" + status;
	}
</script>

</html>