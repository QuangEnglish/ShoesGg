<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${base }/css/trangchuadmin1.css">
    <link rel="stylesheet" href="${base }/css/menu.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <link type="text/css" rel="stylesheet" href="${base }/css/simplePagination.css"/>
    <title>Quản lý phụ kiện</title>
</head>
<body>
    		<jsp:include page="/WEB-INF/views/administrator/layout/menu.jsp"></jsp:include>
            
            <div id="content-right">
                <div class="content-right-top">
                    <form action="${base }/admin/quan-ly-phu-kien" method="get">
                    	<div class="right-top-left">
                        <input type="text" name="timkiemten" placeholder="Tìm kiếm...." class="timkiemten" value="${searchPhuKien.keyword }">
                        <select name="timkiemloaipk" id="">
                        	<option value="0" selected>All</option>
                        	<c:forEach items="${danhMucPhuKien}" var="pk">
                        		<c:if test="${searchPhuKien.danhMucId == pk.id }">
                        			<option selected value="${pk.id }">${pk.tenDanhMuc }</option>
                        		</c:if>
                        		<c:if test="${searchPhuKien.danhMucId != pk.id }">
                        			<option value="${pk.id }">${pk.tenDanhMuc }</option>
                        		</c:if>
                        		
                            	
                        	</c:forEach>
                            
                            
                        </select>
                        <input type="submit" value="Tìm kiếm" class="timkiem"/>
                    </div>
                    </form>
                    <div class="right-top-right">
                        <input type="button" value="Thêm phụ kiện" onclick="themPhuKien()">
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
                <div class="content-right-bottom">
                    <div class="dongsanpham">
                        <table class="bangsanpham">
                            <tr class="dontieude">
                                <th>STT</th>
                                <th>Ảnh</th>
                                <th>Tên sản phẩm</th>
                                <th>Loại sản phẩm</th>
                                <th>Số lượng</th>
                                <th>Đơn giá</th>
                                <th>Trạng thái</th>
                                <th></th>
                            </tr>
                            
                           <c:forEach items="${phuKiens.data }" var="phuKien">
                           		<tr>
                                <td>${index = index + 1 }</td>
                                <td><img src="${base }/image/${phuKien.hinhAnh}" alt="áo polo"></td>
                                <td>${phuKien.tenSanPham }</td>
                                <td>${phuKien.danhMucPhuKien.tenDanhMuc }</td>
                                <td>${phuKien.soLuong }</td>
                                <td>${phuKien.getEpGia() }</td>
                                <td>
                                	<c:if test="${phuKien.status == 1 }">
                                		<i class="ti-check"></i>
                                	</c:if>
                                	<c:if test="${phuKien.status == 0 }">
                                		<i class="ti-close"></i>
                                	</c:if>
                                </td>
                                <td>
                                    <input type="button" name="" id="" value="Sửa" onclick="suaPhuKien('${phuKien.id}')">
                                    <input type="button" name="" id="" value="Xóa" onclick="XacNhanXoa('${phuKien.id }')">
                                    <input type="button" name="" id="" value="Chi tiết">
                                </td>
                            </tr>
                           </c:forEach>
                            
                            
                        
                        </table>
                    </div>
                </div>
                <div class="cuasoxacnhan">
                    <div class="tieude-xacnhan">
                        <p>Xác nhận</p>
                    </div>
                    <div class="noidung-xacnhan">
                        <p>Bạn có chắc muốn xóa không?</p>
                    </div>
                    <div class="nut-xacnhan">
                        <input type="button" value="Có" onclick="DongY()">
                        <input type="button" value="Không" onclick="TuChoi()">
                    </div>
                </div>
            </div>
            <div class="clear"></div>
         </div>
         <div class="clear"></div>
        

         <div class="chuyetrang">
            <form action="${base }/admin/quan-ly-phu-kien" method="post"> 
                <input type="submit" name="sotrang" id="chuyentrang" value="" style="display: none;">
                
            </form>
            <div id="paging"></div>
         </div>

    </div>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/jquery.simplePagination.js"></script>

<script>


$(document).ready(function() {
	$("#paging").pagination({
		currentPage: ${phuKiens.currentPage},
        items: ${phuKiens.totalItems},
        itemsOnPage: ${phuKiens.sizeOfPage},
        cssStyle: 'light-theme',
        onPageClick: function(pageNumber, event) {
			$('#chuyentrang').val(pageNumber);
			$('#chuyentrang').trigger('click');
		}
    });
})

var idXoa = 0;

function XacNhanXoa(id){
    document.querySelector('.cuasoxacnhan').style.display = "block";
    idXoa = id;
}

function DongY() {
	TuChoi();
	XoaPhuKien(idXoa);
}

function TuChoi(){
    document.querySelector('.cuasoxacnhan').style.display = "none";
}

function themPhuKien() {
	window.location = '/admin/them-sua-phu-kien';
}

function suaPhuKien(id) {
	window.location = '/admin/them-sua-phu-kien?idsp=' + id;
}

function  xoaPhuKien(id) {
	window.location = '/admin/xoa-phu-kien?idsp=' + id;
}


function  XoaPhuKien(idXoa) {
	var data = {
			id: idXoa	
	};
	jQuery.ajax({
		url: "/admin/xoa-phu-kien",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json",
		success: function(jsonResult) {
			alert(jsonResult.message);
			window.location = "/admin/quan-ly-phu-kien";
		},
		error: function(jqXhr, textStatus, errorMessage) {
			alert("error");
		}
	});
}

</script>
</html>