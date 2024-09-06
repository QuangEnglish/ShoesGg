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
    <link rel="stylesheet" href="${base }/css/timkiemsanpham.css">
    <link rel="stylesheet" href="${base }/css/header1.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <link type="text/css" rel="stylesheet" href="${base}/css/simplePagination.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/fontawesome.min.css" integrity="sha512-B46MVOJpI6RBsdcU307elYeStF2JKT87SsHZfRSkjVi4/iZ3912zXi45X5/CBr/GbCyLx6M1GQtTKYRd52Jxgw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Tìm kiếm sản phẩm</title>
</head>
<body>
    <div id="body-search">
        <div class="tim-kiem">
            <form action="${base }/tim-kiem-san-pham" method="get" id="form-tim-kiem-1" style="padding: 20px;">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon">Tên sản phẩm</span>
                    <input type="search" class="form-control"  placeholder="Nhập tên sản phẩm" value="${tenSp }" name="tensanpham" class="ten-san-pham"
                           aria-label="Username" aria-describedby="basic-addon">
                </div>
                <div class="d-flex">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon0">Loại danh mục</span>
                        <select name="timkiemloaisp" id="searchiiddanhmuc">
                            <option value="0" selected>Tất cả</option>
                            <c:forEach items="${danhMucSanPhamBac2 }" var="b2">

                                <c:if test="${b2.id == sanPhamSearch.danhMucId }">
                                    <option value="${b2.id }" selected>${b2.tenDanhMuc }</option>
                                </c:if>
                                <c:if test="${b2.id != sanPhamSearch.danhMucId }">
                                    <option value="${b2.id }">${b2.tenDanhMuc }</option>
                                </c:if>

                            </c:forEach>

                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">Giá: (Từ)</span>
                        <input type="text" class="form-control" placeholder="Nhập giá..." name="mingia" class="timkiemten" value="${sanPhamSearch.minPrice }"
                               aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon2">(Đến)</span>
                        <input type="text" class="form-control" placeholder="Nhập giá...." name="maxgia" class="timkiemten" value="${sanPhamSearch.maxPrice }"
                               aria-label="Username" aria-describedby="basic-addon2">
                    </div>
                </div>
                <div class="d-flex" style="justify-content: center;">
                    <i class="ti-search ti-search-filter" onclick="timKiem()"></i>
                </div>
            </form>
        </div>

        <div class="san-pham-tim-kiem">
            <p class="so-san-pham">Có ${soSP } sản phẩm tìm thấy</p>
            <c:forEach items="${sanPhams.data }" var="sp">
            	<div class="dong-san-pham" onclick="ChiTietSanPham('${sp.id}')">
                <img src="${base }/image/${sp.hinhAnh }" alt="">
                <div class="thong-tin-san-pham">
                    <h2 class="ten-san-pham">${sp.tenSanPham }</h2>
                    <p class="mau-sac">${sp.mauSac }</p>
                    <p class="giá">${sp.getEpGia() }đ</p>
                     </div>
                </div>
            </c:forEach>
            
                
           
            <!-- <div class="dong-san-pham">
                <img src="./image/ALS06302.png" alt="">
                <div class="thong-tin-san-pham">
                    <h2 class="ten-san-pham">Áo sơ mi dài tay Aristino ALS22502</h2>
                    <p class="mau-sac">Màu: đen</p>
                    <p class="giá">700000</p>
                </div>
                
            </div> -->
        </div>

        <div class="phan-trang">
        	<form action="${base }/tim-kiem-san-pham" method="post">
        		<input type="submit" id="sotrang" name="sotrang" style="display: none;">
        	</form>
            <div id="paging"></div>
            
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="${base}/js/jquery.simplePagination.js"></script>
<script>
function ChiTietSanPham(id) {
	window.location = "/chi-tiet-san-pham?id=" + id;
}

function timKiem() {
	var tensp = document.querySelector('.ten-san-pham').value;
	if(tensp != ""){
		document.getElementById('form-tim-kiem-1').submit();
	}
	
}

$(document).ready(function() {
	$('#paging').pagination({
		currentPage: ${sanPhams.currentPage},
        items: ${sanPhams.totalItems},
        itemsOnPage: ${sanPhams.sizeOfPage},
        cssStyle: 'light-theme',
        onPageClick: function(pageNumber, event) {
			$("#sotrang").val(pageNumber);
			$("#sotrang").trigger('click');
		}
    });
});
</script>
</html>