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
    <link rel="stylesheet" href="${base }/css/thongtinkhachhang.css">
    <link rel="stylesheet" href="${base }/css/header1.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    
    <title>Document</title>
</head>
<body>
    <div id="thong-tin-khach-hang">
        <form action="${base }/thong-tin-khach-hang" method="post">
            <h2>THÔNG TIN TÀI KHOẢN</h2>
            <table>
                <tr>
                    <td class="truong">Họ tên</td>
                    <td class="nhap"><input type="text" class="ho-ten" name="hoten" value="${khachHang.hoTen }"></td>
                </tr>
                <tr>
                    <td class="truong">Số điện thoại</td>
                    <td class="nhap"><input type="tel" name="sodienthoai" class="so-dien-thoai" value="${khachHang.soDienThoai }"></td>
                </tr>
                <tr>
                    <td class="truong">Email</td>
                    <td class="nhap"><input type="email" name="email" id="" class="email" value="${khachHang.email }"></td>
                </tr>
                <tr>
                    <td class="truong">Giới tính</td>
                    <td class="nhap">
                    	<c:choose>
                    		<c:when test="${khachHang.gioiTinh == 'Nam' }">
                    			<input type="radio" name="gioitinh" checked="checked" value="Nam" class="gioi-tinh">Nam
                       			<input type="radio" name="gioitinh" value="Nữ" class="gioi-tinh">Nữ
                    		</c:when>
                    		<c:otherwise>
                    			<input type="radio" name="gioitinh" value="Nam" class="gioi-tinh">Nam
                       			<input type="radio" name="gioitinh" checked="checked" value="Nữ" class="gioi-tinh">Nữ
                    		</c:otherwise>
                    	</c:choose>
                        
                    </td>
                </tr>
                <tr>
                    <td class="truong">Địa chỉ</td>
                    <td class="nhap">
                        <input type="text" name="diachi" value="${khachHang.diaChi }">
                    </td>
                </tr>
            </table>
            <input type="submit" value="Cập nhật" class="cap-nhat">
        </form>
    </div>
    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
</body>
</html>