<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${base }/css/quanlydanhmucsanpham.css">
    <link rel="stylesheet" href="${base }/css/menu.css">
    <link type="text/css" rel="stylesheet" href="${base }/css/simplePagination.css"/>
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <title>Document</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/administrator/layout/menu.jsp"></jsp:include>
    <div id="content-body">
       <%--  <div class="tab-layout">
            <button class="danh" id="san-pham">Danh mục sản phẩm</button>
           <button class="danh" id="phu-kien">Danh mục phụ kiện</button>
            
        </div> --%>
        <h2>Hãng sản phẩm</h2>
        <div class="tim-kiem">
            <form action="${base }/${link}" method="get">
                <input type="search" class="nhap" placeholder="Tìm kiếm tên danh mục..." name="tendanhmuc" id="">
                <input type="submit" value="Tìm kiếm">
            </form>
            
        </div>
        <div class="danh-muc">
            <div class="them-sua-danh-muc">
            <c:choose>
            	<c:when test="${danhMucSPB2.data != null and danhMucSPB2.data.size() > 0 }">
            		<form action="${base }/admin/them-danh-muc-san-pham" method="post">
	                    <p>Tên hãng sản phẩm: <br>
	                    	<input type="text" name="iddanhmuc" id="id-danh-muc" style="display: none;" required="required">  
	                    	<input type="text" class="nhap" id="sua-danh-muc" name="tendanhmuc" required="required"></input>
	                    	<i class="ti-close xoa" onclick="XoaThem()"></i>
	                    	<input type="submit" value="Thêm" class="nut-danh-muc">
	                    </p>
	                    <p>Chọn danh mục: <br>
	                    	<select style="height: 30px; width: 200px;" name="danhmucbac1" required="required">
	                    		<option value="0">---------</option>
	                    		<c:forEach items="${danhMucSanPhamBac1 }" var="b1">
	                    			<option id="${b1.id }" value="${b1.id }">${b1.tenDanhMuc }</option>
	                    		</c:forEach>
	                    	</select>
	                    </p>
                	</form>
            	</c:when>
            	<c:otherwise>
            		<form action="${base }/admin/them-sua-danh-muc-phu-kien" method="post">
            			<input type="text" name="iddanhmuc" id="id-danh-muc" style="display:none;">  
	                    <input type="text" class="nhap" id="sua-danh-muc" name="tendanhmucpk" required="required">
	                    <i class="ti-close xoa" onclick="XoaThem()"></i>
	                    <input type="submit" value="Thêm" class="nut-danh-muc">
                	</form>
            	</c:otherwise>
            </c:choose>
                
            </div>
            <table>
                <tr>
                    <th>Mã</th>
                    <th>Tên hãng</th>
                    <th>Trạng thái</th>
                    <th>
                        
                    </th>
                </tr>
                
                	<c:if test="${danhMucSPB2.data != null and danhMucSPB2.data.size() > 0}">
                		<c:forEach items="${danhMucSPB2.data }" var="b2">
                		<tr>
                			<td class="trang-thai">${b2.id }</td>
		                    <td>${b2.tenDanhMuc }</td>
		                    <c:choose>
		                    	<c:when test="${b2.status == 1 }">
		                    		<td class="trang-thai"><i class="ti-check"></i></td>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<td class="trang-thai"><i class="ti-close"></i></td>
		                    	</c:otherwise>
		                    </c:choose>
		                    <td>
		                        <a onclick="SuaDanhMuc('${b2.tenDanhMuc}', '${b2.danhMucSanPhamBac1.id }', '${b2.id }')">Sửa</a>|
		                        <a onclick="XoaDanhMucSanPham(${b2.id})">Xóa</a>|
		                        
		                    </td>
		                    </tr>
                		</c:forEach>
                	</c:if>
                	
                	<c:if test="${danhMucPK.data != null }" >
                	
                		<c:forEach items="${danhMucPK.data }" var="pk">
                			<tr>
                			<td class="trang-thai">${pk.id }</td>
		                    <td>${pk.tenDanhMuc }</td>
		                    <c:choose>
		                    	<c:when test="${pk.status == 1 }">
		                    		<td class="trang-thai"><i class="ti-check"></i></td>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<td class="trang-thai"><i class="ti-close"></i></td>
		                    	</c:otherwise>
		                    </c:choose>
		                    <td>
		                        <a onclick="SuaDanhMucPK('${pk.tenDanhMuc}', '${pk.id }')">Sửa</a>|
		                        <a onclick="XoaDanhMucPhuKien(${pk.id})">Xóa</a>|
		                        
		                    </td>
		                    </tr>
                		</c:forEach>
                	</c:if>
                    
                
            </table>
        </div>
        <div class="phan-trang">
        <form action="${base }/${link }" method="post">
            <input type="submit" id="sotrang" name="sotrang" value="" style="display: none">
            
        </form>
        <div id="paging"></div>
    </div>
        
    </div>
    
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/jquery.simplePagination.js"></script>
<script>

    document.getElementById('san-pham').addEventListener('click', function(){
    	window.location = '/admin/quan-ly-danh-muc-san-pham';
            document.getElementById('phu-kien').style.background = 'none';
            document.getElementById('san-pham').style.background = 'blue';
        })

    document.getElementById('phu-kien').addEventListener('click', function(){
    	window.location = '/admin/quan-ly-danh-muc-phu-kien';
        document.getElementById('san-pham').style.background = 'none';
        document.getElementById('phu-kien').style.background = 'blue';
    })

    
     function SuaDanhMuc(tenDanhMuc, id, idB2){
        document.querySelector('.xoa').style.display = 'inline';
        document.getElementById('sua-danh-muc').value = tenDanhMuc;
        document.getElementById('id-danh-muc').value = idB2;
        document.getElementById(id).selected = 'true';
        document.querySelector('.nut-danh-muc').value = 'Cập nhât';
    }
     
     function SuaDanhMucPK(tenDanhMuc, idDanhMuc){
         document.querySelector('.xoa').style.display = 'inline';
         document.getElementById('sua-danh-muc').value = tenDanhMuc;
         document.getElementById('id-danh-muc').value = idDanhMuc;
         document.querySelector('.nut-danh-muc').value = 'Cập nhât';
     }

    function XoaThem(){
        document.getElementById('sua-danh-muc').value = '';
        document.querySelector('.xoa').style.display = 'none';
        document.querySelector('.nut-danh-muc').value = 'Thêm';
    }
    
    
    $(document).ready(function() {
    	$("#paging").pagination({
    		currentPage: ${danhMucSPB2.currentPage},
            items: ${danhMucSPB2.totalItems},
            itemsOnPage: ${danhMucSPB2.sizeOfPage},
            cssStyle: 'light-theme',
            onPageClick: function (pageNumber, event) {
				$("#sotrang").val(pageNumber);
				$("#sotrang").trigger('click');
			}
        });
	})
	
	
	function XoaDanhMucSanPham(id) {
		var data = {
				id: id
		};
		jQuery.ajax({
			url: "/admin/xoa-danh-muc-san-pham",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),
			dataType: "json",
			success: function(jsonResult) {
				alert(jsonResult.message);
				window.location = "/admin/quan-ly-danh-muc-san-pham";
			},
			error: function(jqXhr, textStatus, errorMessage) {
				alert("error");
			}
		});
	}
    
    function XoaDanhMucPhuKien(id) {
		var data = {
				id: id
		};
		jQuery.ajax({
			url: "/admin/xoa-danh-muc-phu-kien",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),
			dataType: "json",
			success: function(jsonResult) {
				alert(jsonResult.message);
				window.location = "/admin/quan-ly-danh-muc-phu-kien";
			},
			error: function(jqXhr, textStatus, errorMessage) {
				alert("error");
			}
		});
	}
	
    
</script>

</html>