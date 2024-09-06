<%@page import="com.devpro.JavaWeb.model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${base }/css/quanlytaikhoan.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="${base }/css/menu.css">
    <link type="text/css" rel="stylesheet" href="${base }/css/simplePagination.css"/>
    <title>Document</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/administrator/layout/menu.jsp"></jsp:include>
	
    <div id="body-content">
        <h1>QUẢN LÝ TÀI KHOẢN</h1>
        <div class="tim-kien-hoa-don">
            <form action="${base }/admin/quan-ly-tai-khoan" method="get">
                <input type="text" placeholder="Nhập tên tài khoản" name="tenkhachhang" id="" class="tim-kiem-ten">
                <input type="submit" name="" id="" value="Tìm kiếm">
            </form>
        </div>
        <table>
            <tr>
                <th>Mã</th>
                <th>Tên tài khoản</th>
                <th>Tên khách hàng</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Trạng thái</th>
                <th></th>
            </tr>
            <c:forEach items="${taiKhoans.data }" var="tk">
            	<c:forEach items="${khachHangs }" var="kh">
            		<c:if test="${kh.id == tk.idKhachHang }">
            			<tr>
            			
			                <td>${tk.id }</td>
			                <td>${tk.username }</td>
			                <td>${kh.hoTen}</td>
			                <td>${kh.soDienThoai }</td>
			                <td>${tk.email }</td>
			                <c:if test="${tk.status == 1 }">
			                	<td><i class="ti-check"></i></td>
			                </c:if>
			                <c:if test="${tk.status == 0 }">
			                	<td><i class="ti-close"></i></td>
			                </c:if>
			                <c:if test="${tk.status == 1 }">
			                	<td>
			                    <input type="button" onclick="XoaTaiKhoan('${tk.id}', 0)" value="Xóa tài khoản">
			                	</td>
			                </c:if>
			                <c:if test="${tk.status == 0 }">
			                	<td>
			                    <input type="button" onclick="XoaTaiKhoan('${tk.id}', 1)" value="Kích hoạt">
			                </td>
			                </c:if>
			                
			            </tr>
            		</c:if>
            	</c:forEach>
            </c:forEach>
            
            
        </table>
        	<form action="${base }/admin/quan-ly-tai-khoan" method="post">
        	 	<input type="submit" name="sotrang" id="trang-tai-khoan" style="display: none;">
        	</form>
        <div id="paging">
        	
        </div>
        
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/jquery.simplePagination.js"></script>
<script>
	$(document).ready(function() {
	    $("#paging").pagination({
	    	currentPage: ${taiKhoans.currentPage},
	        items: ${taiKhoans.totalItems},
	        itemsOnPage: ${taiKhoans.sizeOfPage},
	        cssStyle: 'light-theme',
	        onPageClick: function (pageNumber, event) {
				$("#trang-tai-khoan").val(pageNumber);
				$("#trang-tai-khoan").trigger("click");
			}
	    });
	});
	
	
	function XoaTaiKhoan(id, st) {
		var data = {
			id: id,
			stastus: st
		};
		jQuery.ajax({
			url: "/admin/xoa-tai-khoan",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),
			dataType: "json",
			success: function(result) {
				alert(result.message);
				window.location = "/admin/quan-ly-tai-khoan";
			}
		})
	}

</script>


</html>